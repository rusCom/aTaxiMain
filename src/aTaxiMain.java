import API.MainAPI;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class aTaxiMain {
    static Database dataBase;
    static boolean work;
    static JSONObject baseAnswer, baseMessage;
    static JSONArray baseMessages;

    static int sleepTimer, qiwiTimer, qiwiCheckTimer;
    static String curDir;

    public static void main(String[] args) throws IOException, CacheException {
        Properties properties = new Properties();
        curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/ataxi.properties");
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

        qiwiCheckTimer = 0;


        while (true) {
            work = false;
            qiwiCheckTimer++;

            if (qiwiCheckTimer > qiwiTimer) {
                try {
                    baseAnswer = new JSONObject(MainAPI.PaymentsQiwiToken(dataBase));
                    MainUtils.getInstance().printFileLog("qiwi", "start qiwi check for number " + baseAnswer.getString("phone") + " with token " + baseAnswer.getString("token"), true);
                    String qiwiNumber = baseAnswer.getString("phone");
                    String urlString = "https://edge.qiwi.com/payment-history/v2/persons/" + qiwiNumber + "/payments?rows=50";
                    JSONObject respJSON = httpGet(urlString, "Bearer " + baseAnswer.getString("token"));
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
                                    MainUtils.getInstance().printFileLog("qiwi", payment.toString(), true);
                                }

                            }
                        }
                    }
                    qiwiCheckTimer = 0;
                    work = true;
                    MainUtils.getInstance().printFileLogSeparator("qiwi");
                } catch (Exception e) {
                    MainUtils.getInstance().printException("qiwi", e);
                }
            }


            if (!work) {
                try {
                    baseAnswer = new JSONObject(MainAPI.MessagesFirebase(dataBase));
                    if (baseAnswer.getInt("count") > 0) {
                        work = true;
                        baseMessages = baseAnswer.getJSONArray("messages");
                        for (int itemID = 0; itemID < baseMessages.length(); itemID++) {
                            baseMessage = baseMessages.getJSONObject(itemID);
                            MainUtils.getInstance().printFileLog("fcm", baseMessage.toString(), true);


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
                            MainUtils.getInstance().printFileLog("fcm", message.toString(), true);
                            JSONObject respJSON = MainUtils.httpPost("https://fcm.googleapis.com/fcm/send", message.toString(), "key=" + baseMessage.getString("key"));
                            MainUtils.getInstance().printFileLog("fcm", respJSON.toString(), true);

                            if (respJSON.getString("status").equals("OK")) {
                                if (MainUtils.JSONGetString(respJSON, "success").equals("1")) {
                                    MainAPI.MessagesSetSended(dataBase, baseMessage.getString("id"));
                                } else {
                                    MainAPI.MessagesSetNotSended(dataBase, baseMessage.getString("id"), "");
                                }
                            } else {
                                MainAPI.MessagesSetNotSended(dataBase, baseMessage.getString("id"), respJSON.getString("error"));
                            }

                        } // for (int itemID = 0; itemID < baseMessages.length(); itemID++){
                    } // if (work && baseAnswer.getInt("count") > 0){
                } catch (Exception e) {
                    MainUtils.getInstance().printException("fcm", e);
                }
            } // if (!work){

            if (!work) { // смотрим СМС на отправку, если не было отправкисообщений
                try {
                    baseAnswer = new JSONObject(API.SMSC.GetMessages(dataBase));
                    if (baseAnswer.getInt("count") > 0) {
                        work = true;
                        baseMessages = baseAnswer.getJSONArray("messages");
                        for (int itemID = 0; itemID < baseMessages.length(); itemID++) {
                            baseMessage = baseMessages.getJSONObject(itemID);
                            MainUtils.getInstance().printFileLog("smsc", baseAnswer.toString(), true);
                            String urlString = "http://smsc.ru/sys/send.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                    "&phones=" + baseMessage.getString("phone") + "&mes=" + URLEncoder.encode(baseMessage.getString("message"), java.nio.charset.StandardCharsets.UTF_8.toString()) + "&cost=3&fmt=3&id=" + baseMessage.getString("id");
                            JSONObject respJSON = httpGet(urlString);
                            MainUtils.getInstance().printFileLog("smsc", respJSON.toString(), true);
                            if (respJSON.has("id")) {
                                API.SMSC.SetSended(dataBase, String.valueOf(respJSON.getInt("id")), String.valueOf(respJSON.getInt("cnt")), respJSON.getString("cost"), respJSON.getString("balance"));
                            }
                            MainUtils.getInstance().printFileLogSeparator("smsc");
                        } // for (int itemID = 0; itemID < baseMessages.length(); itemID++){
                    } // if (work && baseAnswer.getInt("count") > 0){
                } catch (Exception e) {
                    MainUtils.getInstance().printException("smsc", e);
                }
            } // СМС на отправку

            if (!work) { // Если сообщений на отправку нет, то проверяем на доставку сообщений
                try {
                    baseAnswer = new JSONObject(API.SMSC.GetMessagesForCheckStatus(dataBase));
                    if (baseAnswer.getInt("count") > 0) {
                        work = true;
                        baseMessages = baseAnswer.getJSONArray("messages");
                        for (int itemID = 0; itemID < baseMessages.length(); itemID++) {
                            baseMessage = baseMessages.getJSONObject(itemID);
                            MainUtils.getInstance().printFileLog("smsc", baseAnswer.toString(), true);
                            String urlString = "http://smsc.ru/sys/status.php?login=" + baseMessage.getString("login") + "&psw=" + baseMessage.getString("psw") +
                                    "&phone=" + baseMessage.getString("phone") + "&fmt=3&id=" + baseMessage.getString("id");
                            JSONObject respJSON = httpGet(urlString);
                            MainUtils.getInstance().printFileLog("smsc", respJSON.toString(), true);
                            if (respJSON.has("status")) {
                                API.SMSC.SetStatus(dataBase, baseMessage.getString("id"), String.valueOf(respJSON.getInt("status")), "");
                            }
                            MainUtils.getInstance().printFileLogSeparator("smsc");
                        } // for (int itemID = 0; itemID < baseMessages.length(); itemID++){
                        work = true;
                    } // if (work && baseAnswer.getInt("count") > 0){
                } catch (Exception e) {
                    MainUtils.getInstance().printException("smsc", e);
                }
            } // Если сообщений на отправку нет, то проверяем на доставку сообщений


            if (!work) {
                try {
                    baseAnswer = new JSONObject(API.SMSC.GetDistanceForCalc(dataBase));
                    JSONArray results = baseAnswer.getJSONArray("result");
                    for (int itemID = 0; itemID < results.length(); itemID++) {
                        JSONObject dist = results.getJSONObject(itemID);
                        MainUtils.getInstance().printFileLog("distance", dist.toString(), true);
                        String urlString = "http://geo.toptaxi.org/distance/cache?blt=" + dist.getString("blt") + "&bln=" + dist.getString("bln") + "&elt=" + dist.getString("elt") + "&eln=" + dist.getString("eln");
                        JSONObject respJSON = httpGet(urlString);
                        MainUtils.getInstance().printFileLog("distance", respJSON.toString(), true);
                        if (respJSON.getString("status").equals("OK")) {
                            JSONObject result = respJSON.getJSONObject("result");
                            API.SMSC.SetDistance(dataBase, dist.getString("id"), MainUtils.JSONGetString(result, "distance"), MainUtils.JSONGetString(result, "status"));
                        } else {
                            API.SMSC.SetDistance(dataBase, dist.getString("id"), "-1", respJSON.getString("status"));
                        }
                        MainUtils.getInstance().printFileLogSeparator("distance");
                        work = true;
                    } // for (int itemID = 0; itemID < results.length(); itemID++){
                } catch (Exception e) {
                    MainUtils.getInstance().printException("distance", e);
                }
            }

            work = true;

            if (!work) {
                try {
                    baseAnswer = new JSONObject(API.SMSC.DriverGPSMonitorGetForGeocooding(dataBase));
                    JSONArray results = baseAnswer.getJSONArray("result");
                    for (int itemID = 0; itemID < results.length(); itemID++) {
                        JSONObject dist = results.getJSONObject(itemID);

                        String urlString = "http://geo.toptaxi.org/geocode/driver?lt=" + dist.getString("lt") + "&ln=" + dist.getString("ln");
                        JSONObject respJSON = httpGet(urlString);

                        if (respJSON.getString("status").equals("OK")) {
                            JSONObject result = respJSON.getJSONObject("result");
                            API.SMSC.DriverGPSMonitorSetLocationName(dataBase, dist.getString("lt"), dist.getString("ln"), result.getString("name"), result.getString("dsc"));
                            API.SMSC.DriverGPSMonitorSetLocationName(dataBase, result.getString("lt"), result.getString("ln"), result.getString("name"), result.getString("dsc"));
                        } else {
                            API.SMSC.DriverGPSMonitorSetLocationName(dataBase, dist.getString("lt"), dist.getString("ln"), respJSON.getString("status"), " ");
                        }
                        work = true;
                    } // for (int itemID = 0; itemID < results.length(); itemID++){
                } catch (Exception e) {
                    MainUtils.getInstance().printException("gpsMonitorGeocoding", e);
                }
            }

            try {
                sleep(sleepTimer * 1000);
            } catch (InterruptedException e) {
                MainUtils.getInstance().printException("sleep", e);
            }
        }// while (true) {

    }

    static JSONObject httpGet(String urlString, String Authorization) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (!Authorization.equals("")) {
                conn.setRequestProperty("Authorization", Authorization);
            }
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            result = new JSONObject(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    static JSONObject httpGet(String urlString) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            result = new JSONObject(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
