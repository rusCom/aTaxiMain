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
    static EmailService emailService;

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

        boolean distanceCalc = Boolean.parseBoolean(properties.getProperty("server.distancecalc", "true"));
        boolean geocodeDriver = Boolean.parseBoolean(properties.getProperty("server.geocodedriver", "true"));

        System.out.println(MainUtils.getCurDateTime() + "Properties loaded");
        System.out.println(MainUtils.getCurDateTime() + "Connecting to DataBase " + dataBaseURL);
        dataBase = CacheDatabase.getDatabase(dataBaseURL, dataBaseUser, dataBasePwd);
        System.out.println(MainUtils.getCurDateTime() + "Connecting to DataBase " + dataBaseURL + " success");

        mainUtils = new MainUtils();

        qiwiCheckTimer = 0;

        JSONObject respJSON;


        while (true) {
            work = false;
            qiwiCheckTimer++;

            if (qiwiCheckTimer > qiwiTimer) {
                try {
                    baseAnswer = new JSONObject(MainAPI.PaymentsQiwiToken(dataBase));
                    mainUtils.printFileLog("qiwi", "start qiwi check for number " + baseAnswer.getString("phone") + " with token " + baseAnswer.getString("token"), true);
                    String qiwiNumber = baseAnswer.getString("phone");
                    String urlString = "https://edge.qiwi.com/payment-history/v2/persons/" + qiwiNumber + "/payments?rows=50";
                    respJSON = MainUtils.httpGet(urlString, "Bearer " + baseAnswer.getString("token"));
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


            try {
                JSONArray messages = new JSONArray(Messages.Messages(dataBase));
                for (int itemID = 0; itemID < messages.length(); itemID++) {
                    baseMessage = messages.getJSONObject(itemID);
                    mainUtils.printFileLog("baseMessage", baseMessage.toString(), true);
                    switch (baseMessage.getString("terminal")) {
                        case "sms":
                            mainUtils.printFileLog("sms", baseMessage.toString(), true);
                            try {
                                if (baseMessage.getString("provider").equals("SMSC.RU")) {
                                    if (baseMessage.getString("status").equals("0")) {
                                        String urlString = "http://smsc.ru/sys/send.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                                "&phones=" + baseMessage.getString("phone") + "&mes=" + URLEncoder.encode(baseMessage.getString("message"), java.nio.charset.StandardCharsets.UTF_8.toString()) + "&cost=3&fmt=3&id=" + baseMessage.getString("id");

                                        respJSON = MainUtils.httpGet(urlString);
                                        mainUtils.printFileLog("sms", respJSON.toString(), true);
                                        if (respJSON.has("error_code")) {
                                            Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended", "", "", MainUtils.JSONGetString(respJSON, "error"));
                                        } else if (respJSON.has("id")) {
                                            Messages.SetStatus(dataBase, MainUtils.JSONGetString(respJSON, "id"), "sended", MainUtils.JSONGetString(respJSON, "cnt"), MainUtils.JSONGetString(respJSON, "cost"));
                                        }
                                    } else if (baseMessage.getString("status").equals("2")) {
                                        String urlString = "http://smsc.ru/sys/status.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                                "&phone=" + baseMessage.getString("phone") + "&fmt=3&id=" + baseMessage.getString("id");
                                        respJSON = MainUtils.httpGet(urlString);
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

                            } catch (Exception ex) {
                                mainUtils.printFileLog("sms", ex.toString(), true);
                                mainUtils.printException("sms", ex);
                            }
                            mainUtils.printFileLogSeparator("sms");


                            break;
                        case "fcm":
                            mainUtils.printFileLog("fcm", baseMessage.toString(), true);
                            try {
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
                                respJSON = MainUtils.httpPost("https://fcm.googleapis.com/fcm/send", message.toString(), "key=" + baseMessage.getString("key"));
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
                            } catch (Exception ex) {
                                mainUtils.printFileLog("fcm", ex.toString(), true);
                                mainUtils.printException("fcm", ex);
                            }
                            mainUtils.printFileLogSeparator("fcm");
                            break;
                        case "taxsee":
                            mainUtils.printFileLog("taxsee", baseMessage.toString(), true);
                            try {
                                if (baseMessage.getString("action").equals("set_status")) {
                                    mainUtils.printFileLog("taxsee", baseMessage.toString(), true);
                                    String urlString = "https://dev-api.taxsee.com/tsv1/owner/set_status?order_id=" + baseMessage.getString("order_id") + "&status=" + baseMessage.getString("status");
                                    if (baseMessage.getString("status").equals("Finished")) {
                                        urlString += "&price=" + baseMessage.getString("price");
                                    }
                                    Messages.SetStatus(dataBase, baseMessage.getString("id"), "sended");
                                    respJSON = MainUtils.httpPost(urlString, baseMessage.getJSONObject("body").toString(), baseMessage.getString("key"));
                                    mainUtils.printFileLog("taxsee", respJSON.toString(), true);

                                    if (respJSON.getString("status").equals("OK")) {
                                        Messages.SetStatus(dataBase, baseMessage.getString("id"), "sended");
                                    } else {
                                        Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended", "0", "0", respJSON.getString("error"));
                                    }
                                }
                            } catch (Exception ex) {
                                mainUtils.printFileLog("taxsee", ex.toString(), true);
                                mainUtils.printException("taxsee", ex);
                            }

                            mainUtils.printFileLogSeparator("taxsee");
                            break; // taxsee
                        case "insurance":
                            mainUtils.printFileLog("insurance", baseMessage.toString(), true);
                            try{
                                if (emailService == null) {
                                    JSONObject mailData = new JSONObject(Messages.Insurance(dataBase));
                                    emailService = new EmailService(mailData.getString("host"), Integer.parseInt(mailData.getString("port")), mailData.getString("username"), mailData.getString("password"), mailData.getString("from"));
                                }

                                emailService.sendMail(baseMessage.getString("to"), baseMessage.getString("subject"), baseMessage.getString("body"), baseMessage.getString("attachment"));
                                Messages.SetStatus(dataBase, baseMessage.getString("id"), "sended");
                            }catch (Exception ex) {
                                mainUtils.printFileLog("insurance", ex.toString(), true);
                                Messages.SetStatus(dataBase, baseMessage.getString("id"), "not_sended", "", "", ex.toString());
                                mainUtils.printException("insurance", ex);
                            }
                            mainUtils.printFileLogSeparator("insurance");

                            break;
                    }
                }
            } catch (Exception e) {
                mainUtils.printException("messages", e);
            }


            if (distanceCalc) {
                try {
                    JSONArray dataArray = new JSONArray(GEO2.DistanceForCalc(dataBase));
                    for (int itemID = 0; itemID < dataArray.length(); itemID++) {
                        JSONObject data = dataArray.getJSONObject(itemID);
                        mainUtils.printFileLog("distance", data.toString(), true);
                        String urlString = "http://geo.toptaxi.org/distance?blt=" + data.getString("blt") + "&bln=" + data.getString("bln") + "&elt=" + data.getString("elt") + "&eln=" + data.getString("eln");
                        respJSON = MainUtils.httpGet(urlString);
                        mainUtils.printFileLog("distance", respJSON.toString(), true);
                        if (respJSON.getString("status").equals("OK")) {
                            JSONObject result = respJSON.getJSONObject("result");
                            GEO2.DistanceSet(dataBase, data.getString("blt"), data.getString("bln"), data.getString("elt"), data.getString("eln"), MainUtils.JSONGetString(result, "distance"), MainUtils.JSONGetString(result, "duration"), MainUtils.JSONGetString(result, "status"));
                        }
                    }
                } catch (Exception e) {
                    mainUtils.printException("distance", e);
                }
            }

            if (geocodeDriver) {
                try {
                    JSONArray dataArray = new JSONArray(GEO2.GeoCodeDriverGPSMonitor(dataBase));
                    for (int itemID = 0; itemID < dataArray.length(); itemID++) {
                        JSONObject data = dataArray.getJSONObject(itemID);
                        mainUtils.printFileLog("geocode", data.toString(), true);
                        String urlString = "http://geo.toptaxi.org/geocode?lt=" + data.getString("lt") + "&ln=" + data.getString("ln");
                        respJSON = MainUtils.httpGet(urlString);
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
            }


            try {
                sleep(sleepTimer * 1000);
            } catch (InterruptedException e) {
                mainUtils.printException("sleep", e);
            }
        }// while (true) {
    } // main

    void sendEMail() {

    }
}
