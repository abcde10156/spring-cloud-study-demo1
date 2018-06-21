package com.luotao.demo.sc;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.MethodHandles;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String METHOD_POST = "POST";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_TEXT = "application/x-www-form-urlencoded";
    private static final int DEFAULT_CONNECT_TIMEOUT = 5000;
    private static final int DEFAULT_READ_TIMEOUT = 5000;

    public HttpUtils() {
    }

    public static byte[] doGet(String str_url, int connectTimeout, int readTimeout) {
        HttpURLConnection conn = null;
        InputStream input = null;

        byte[] var6;
        try {
            URL e = new URL(str_url);
            conn = (HttpURLConnection)e.openConnection();
            conn.setDoOutput(true);
            if(connectTimeout <= 0) {
                conn.setConnectTimeout(5000);
            } else {
                conn.setConnectTimeout(connectTimeout);
            }

            if(readTimeout <= 0) {
                conn.setReadTimeout(5000);
            } else {
                conn.setReadTimeout(readTimeout);
            }

            input = conn.getInputStream();
            var6 = parseFromInputStream(input);
        } catch (Exception var15) {
            logger.error("HttpUtils Get Error", var15);
            throw new RuntimeException(var15);
        } finally {
            if(conn != null) {
                conn.disconnect();
            }

            if(input != null) {
                try {
                    input.close();
                } catch (IOException var14) {
                    var14.printStackTrace();
                }
            }

        }

        return var6;
    }

    public static byte[] doGet(String str_url) {
        return doGet(str_url, 5000, 5000);
    }

    public static String doGetStr(String str_url, String encoding) {
        byte[] res_bytes = doGet(str_url, 5000, 5000);

        try {
            return new String(res_bytes, encoding);
        } catch (UnsupportedEncodingException var4) {
            return new String(res_bytes);
        }
    }

    public static String doGetStr(String str_url, String encoding, int connectTimeout, int readTimeout) {
        byte[] res_bytes = doGet(str_url, connectTimeout, readTimeout);

        try {
            return new String(res_bytes, encoding);
        } catch (UnsupportedEncodingException var6) {
            return new String(res_bytes);
        }
    }

    public static String doPostMapStr(String str_url, String params, int conn_timeout, int read_timeout, String encoding) {
        byte[] res_bytes = doPost(str_url, params, conn_timeout, read_timeout);

        try {
            return new String(res_bytes, encoding);
        } catch (UnsupportedEncodingException var7) {
            return new String(res_bytes);
        }
    }

    public static String doPostStr(String str_url, Map<String, String> params, int conn_timeout, int read_timeout, String encoding) {
        byte[] res_bytes = doPost(str_url, params, conn_timeout, read_timeout);

        try {
            return new String(res_bytes, encoding);
        } catch (UnsupportedEncodingException var7) {
            return new String(res_bytes);
        }
    }

    public static byte[] doPost(String str_url, Map<String, String> paramsMap, int conn_timeout, int read_timeout) {
        StringBuilder sb = new StringBuilder();
        if(paramsMap != null && paramsMap.size() > 0) {
            int i = 0;

            for(Iterator var6 = paramsMap.entrySet().iterator(); var6.hasNext(); ++i) {
                Entry entry = (Entry)var6.next();
                if(i > 0) {
                    sb.append("&");
                }

                sb.append((String)entry.getKey()).append("=").append((String)entry.getValue());
            }
        }

        return doPost(str_url, sb.toString(), conn_timeout, read_timeout);
    }

    public static byte[] doPost(String str_url, String params, int conn_timeout, int read_timeout) {
        return doPost(str_url, params, conn_timeout, read_timeout, new HashMap());
    }

    public static byte[] doPost(String str_url, String params, int conn_timeout, int read_timeout, Map<String, String> headerMap) {
        HttpURLConnection connection = null;
        InputStream input = null;

        try {
            URL e = new URL(str_url);
            connection = (HttpURLConnection)e.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setConnectTimeout(conn_timeout);
            connection.setReadTimeout(read_timeout);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("connection", "close");
            Iterator out = headerMap.entrySet().iterator();

            while(out.hasNext()) {
                Entry entry = (Entry)out.next();
                connection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }

            connection.connect();
            DataOutputStream out1 = new DataOutputStream(connection.getOutputStream());
            out1.write(params.getBytes("UTF-8"));
            out1.flush();
            out1.close();
            input = connection.getInputStream();
            byte[] entry1 = parseFromInputStream(input);
            return entry1;
        } catch (Exception var18) {
            logger.error("HttpUtils Post Error", var18);
            throw new RuntimeException(var18);
        } finally {
            if(connection != null) {
                connection.disconnect();
            }

            if(input != null) {
                try {
                    input.close();
                } catch (IOException var17) {
                    var17.printStackTrace();
                }
            }

        }
    }

    public static byte[] parseFromInputStream(InputStream input) throws IOException {
        byte[] by_result = new byte[input.available()];
        input.read(by_result);
        input.close();
        return by_result;
    }
}
