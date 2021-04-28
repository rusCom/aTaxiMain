import API.GEO2;
import API.MainAPI;
import API.Messages;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URLEncoder;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class aTaxiMain {
    static Database dataBase;
    static boolean work;
    static JSONObject baseAnswer, baseMessage;

    static int sleepTimer, qiwiTimer, qiwiCheckTimer;
    static String curDir;
    static MainUtils mainUtils;

    public static void main(String[] args) throws IOException, CacheException {
        Properties properties = new Properties();
        curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/server.properties");
        properties.load(fis);

        String dataBaseURL = "jdbc:Cache://" + properties.getProperty("db.address") + ":" + properties.getProperty("db.port") + "/" + properties.getProperty("db.namespace") + "";
        String dataBaseUser = properties.getProperty("db.username");
        String dataBasePwd = properties.getProperty("db.password");

        sleepTimer = Integer.parseInt(properties.getProperty("sleepTimer"));
        qiwiTimer = Integer.parseInt(properties.getProperty("qiwiTimer"));

        System.out.println(MainUtils.getCurDateTime() + "Properties loaded");
        System.out.println(MainUtils.getCurDateTime() + "Connecting to DataBase " + dataBaseURL);
        dataBase = CacheDatabase.getDatabase(dataBaseURL, dataBaseUser, dataBasePwd);
        System.out.println(MainUtils.getCurDateTime() + "Connecting to DataBase " + dataBaseURL + " success");

        mainUtils = new MainUtils();

        qiwiCheckTimer = 0;


        while (true) {
            work = false;
            qiwiCheckTimer++;

            if (qiwiCheckTimer > qiwiTimer) {
                try {
                    baseAnswer = new JSONObject(MainAPI.PaymentsQiwiToken(dataBase));
                    mainUtils.printFileLog("qiwi", "start qiwi check for number " + baseAnswer.getString("phone") + " with token " + baseAnswer.getString("token"), true);
                    String qiwiNumber = baseAnswer.getString("phone");
                    String urlString = "https://edge.qiwi.com/payment-history/v2/persons/" + qiwiNumber + "/payments?rows=50";
                    JSONObject respJSON = MainUtils.httpGet(urlString, "Bearer " + baseAnswer.getString("token"));
                    if (respJSON.has("data")) {
                        JSONArray data = respJSON.getJSONArray("data");
                        for (int itemID = 0; itemID < data.length(); itemID++) {
                            JSONObject payment = data.getJSONObject(itemID);
                            if ((payment.getInt("errorCode") == 0) & (payment.getString("type").equals("IN"))) {
                                String res = MainAPI.PaymentsQiwi(dataBase, String.valueOf(payment.getInt("txnId")),
                                        qiwiNumber,
                                        payment.getString("date"),
                                        String.valueOf(payment.get("comment")),
                                        String.valueOf(payment.getJSONObject("total").getInt("amount"))
                                );
                                if (!res.equals("3")) {
                                    mainUtils.printFileLog("qiwi", payment.toString(), true);
                                }

                            }
                        }
                    }
                    qiwiCheckTimer = 0;
                    work = true;
                    mainUtils.printFileLogSeparator("qiwi");
                } catch (Exception e) {
                    mainUtils.printException("qiwi", e);
                }
            }

            if (!work) {
                try {
                    JSONArray messages = new JSONArray(Messages.Messages(dataBase));
                    for (int itemID = 0; itemID < messages.length(); itemID++) {
                        baseMessage = messages.getJSONObject(itemID);
                        switch (baseMessage.getString("terminal")) {
                            case "sms":
                                mainUtils.printFileLog("sms", baseMessage.toString(), true);
                                if (baseMessage.getString("provider").equals("SMSC.RU")) {
                                    if (baseMessage.getString("status").equals("0")) {
                                        String urlString = "http://smsc.ru/sys/send.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                                "&phones=" + baseMessage.getString("phone") + "&mes=" + URLEncoder.encode(baseMessage.getString("message"), java.nio.charset.StandardCharsets.UTF_8.toString()) + "&cost=3&fmt=3&id=" + baseMessage.getString("id");

                                        JSONObject respJSON = MainUtils.httpGet(urlString);
                                        mainUtils.printFileLog("sms", respJSON.toString(), true);
                                        if (respJSON.has("error_code")) {
                                            Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended", "", "", MainUtils.JSONGetString(respJSON, "error"));
                                        } else if (respJSON.has("id")) {
                                            Messages.SetStatus(dataBase, MainUtils.JSONGetString(respJSON, "id"), "sended", MainUtils.JSONGetString(respJSON, "cnt"), MainUtils.JSONGetString(respJSON, "cost"));
                                        }
                                    } else if (baseMessage.getString("status").equals("2")) {
                                        String urlString = "http://smsc.ru/sys/status.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                                "&phone=" + baseMessage.getString("phone") + "&fmt=3&id=" + baseMessage.getString("id");
                                        JSONObject respJSON = MainUtils.httpGet(urlString);
                                        mainUtils.printFileLog("sms", respJSON.toString(), true);
                                        if (respJSON.has("status")) {
                                            if (MainUtils.JSONGetString(respJSON, "status").equals("1")) {
                                                Messages.SetStatus(dataBase, baseMessage.getString("id"), "delivered");
                                            } else if (!MainUtils.JSONGetString(respJSON, "status").equals("0")) {
                                                Messages.SetStatus(dataBase, baseMessage.getString("id"), "delayed");
                                            }
                                        }
                                    }
                                }
                                mainUtils.printFileLogSeparator("sms");
                                break;
                            case "fcm":
                                mainUtils.printFileLog("fcm", baseMessage.toString(), true);
                                JSONObject message = new JSONObject();
                                message.put("to", baseMessage.getString("destenation"));
                                JSONObject notification = new JSONObject();
                                if (!baseMessage.getString("body").equals("")) {
                                    notification.put("body", baseMessage.getString("body"));
                                }
                                if (!baseMessage.getString("title").equals("")) {
                                    notification.put("title", baseMessage.getString("title"));
                                }
                                message.put("notification", notification);
                                mainUtils.printFileLog("fcm", message.toString(), true);
                                JSONObject respJSON = MainUtils.httpPost("https://fcm.googleapis.com/fcm/send", message.toString(), "key=" + baseMessage.getString("key"));
                                mainUtils.printFileLog("fcm", respJSON.toString(), true);
                                if (respJSON.getString("status").equals("OK")) {
                                    if (MainUtils.JSONGetString(respJSON, "success").equals("1")) {
                                        Messages.SetStatus(dataBase, baseMessage.getString("id"), "sended");
                                    } else {
                                        Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended");
                                    }
                                } else {
                                    Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended", "0", "0", respJSON.getString("error"));

                                }
                                mainUtils.printFileLogSeparator("fcm");
                                break;
                            case "taxsee":

                                break;
                        }
                    }
                } catch (Exception e) {
                    mainUtils.printException("messages", e);
                }
            }

            try {
                JSONArray dataArray = new JSONArray(GEO2.DistanceForCalc(dataBase));
                for (int itemID = 0; itemID < dataArray.length(); itemID++){
                    JSONObject data = dataArray.getJSONObject(itemID);
                    mainUtils.printFileLog("distance", data.toString(), true);
                    String urlString = "http://geo.toptaxi.org/distance?blt=" + data.getString("blt") + "&bln=" + data.getString("bln") + "&elt=" + data.getString("elt") + "&eln=" + data.getString("eln");
                    JSONObject respJSON = MainUtils.httpGet(urlString);
                    mainUtils.printFileLog("distance", respJSON.toString(), true);
                    if (respJSON.getString("status").equals("OK")) {
                        JSONObject result = respJSON.getJSONObject("result");
                        GEO2.DistanceSet(dataBase, data.getString("blt"), data.getString("bln"), data.getString("elt"), data.getString("eln"), MainUtils.JSONGetString(result, "distance"), MainUtils.JSONGetString(result, "duration"), MainUtils.JSONGetString(result, "status"));
                    }
                }
            } catch (Exception e) {
                mainUtils.printException("distance", e);
            }


            try {
                JSONArray dataArray = new JSONArray(GEO2.GeoCodeDriverGPSMonitor(dataBase));
                for (int itemID = 0; itemID < dataArray.length(); itemID++){
                    JSONObject data = dataArray.getJSONObject(itemID);
                    mainUtils.printFileLog("geocode", data.toString(), true);
                    String urlString = "http://geo.toptaxi.org/geocode?lt=" + data.getString("lt") + "&ln=" + data.getString("ln");
                    JSONObject respJSON = MainUtils.httpGet(urlString);
                    mainUtils.printFileLog("geocode", respJSON.toString(), true);

                    if (respJSON.getString("status").equals("OK")) {
                        JSONObject result = respJSON.getJSONObject("result");
                        GEO2.GeoCodeDriverGPSMonitorSet(dataBase, data.getString("lt"), data.getString("ln"), result.getString("name"), result.getString("dsc"));
                        GEO2.GeoCodeDriverGPSMonitorSet(dataBase, result.getString("lt"), result.getString("ln"), result.getString("name"), result.getString("dsc"));

                    } else {
                        GEO2.GeoCodeDriverGPSMonitorSet(dataBase, data.getString("lt"), data.getString("ln"), respJSON.getString("status"));
                    }


                }
            } catch (Exception e) {
                mainUtils.printException("geocode", e);
            }


            try {
                sleep(sleepTimer * 1000);
            } catch (InterruptedException e) {
                mainUtils.printException("sleep", e);
            }
        }// while (true) {

    } // main


}
