import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MainUtils {
    private String curDir, severType;
    private Map<String, PrintWriter> printWriterMap;
    private static volatile MainUtils instance;

    public static MainUtils getInstance() throws IOException {
        MainUtils localInstance = instance;
        if (localInstance == null) {
            synchronized (MainUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new MainUtils();
                }
            }
        }
        return localInstance;
    }

    public MainUtils() throws IOException {
        printWriterMap = new HashMap<String, PrintWriter>();
        Properties properties = new Properties();
        curDir = new File("").getAbsolutePath();
        FileInputStream fis = new FileInputStream(curDir + "/server.properties");
        properties.load(fis);
        severType = properties.getProperty("server.type");

        new File(curDir + "/log/").mkdir();

    }

    public void printFileLogSeparator(String logType) throws FileNotFoundException {
        getLogPrintWriter(logType).println("********************************************************************************************************");
        getLogPrintWriter(logType).flush();
    }

    public void printFileLog(String logType, String logString, boolean timeStamp) throws FileNotFoundException {
        if (timeStamp) {
            logString = getCurDateTime() + logString;
        }
        getLogPrintWriter(logType).println(logString);
        getLogPrintWriter(logType).flush();
    }

    public void printException(String logType, Exception exception) throws FileNotFoundException {
        printFileLog("exception", logType, true);
        printFileLog("exception", exception.getMessage(), true);
        printFileLogSeparator("exception");
    }

    private PrintWriter getLogPrintWriter(String logType) throws FileNotFoundException {
        if (printWriterMap.get(logType) == null) {
            String logFileName = curDir + "/log/" + severType + "_" + getCurDateTime().replace(" ", "_").replace(":", "_").replace("-", "_") + logType + ".txt";
            PrintWriter printWriter = new PrintWriter(logFileName);
            printWriterMap.put(logType, printWriter);
        }
        return printWriterMap.get(logType);
    }

    static String JSONGetString(JSONObject data, String field) {
        String result = "";
        if (data.has(field)) {
            Object object = data.get(field);

            if (object instanceof Boolean) {
                if (((Boolean) object)) {
                    result = "1";
                } else {
                    result = "0";
                }
            } else {
                result = String.valueOf(object);
            }
            if (result.equals("true")) {
                result = "1";
            }
            if (result.equals("false")) {
                result = "0";
            }
        }
        return result;
    }

    static JSONObject httpPost(String urlString, String data, String authorization) {
        JSONObject result = new JSONObject();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (!authorization.equals("")) {
                conn.setRequestProperty("Authorization", authorization);
            }
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            result.put("status", "OK");
            try {
                JSONObject jsonObject = new JSONObject(resp);
                result.put("type", "object");
                result.put("body", jsonObject);
            } catch (JSONException objectException) {
                try {
                    JSONArray jsonArray = new JSONArray(resp);
                    result.put("type", "array");
                    result.put("body", jsonArray);
                } catch (JSONException arrayException) {
                    result.put("type", "text");
                    result.put("body", resp);
                }
            }
        } catch (IOException e) {
            result.put("status", "error");
            result.put("error", e.getMessage());
        }
        return result;
    }

    static String getCurDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " - ";
    }
}
