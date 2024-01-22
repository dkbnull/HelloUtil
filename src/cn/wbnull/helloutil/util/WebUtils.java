package cn.wbnull.helloutil.util;

import cn.wbnull.helloutil.constant.ContentType;
import cn.wbnull.helloutil.constant.UtilConstants;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

/**
 * Web 工具类
 *
 * @author dukunbiao(null)  2018-09-08
 * https://github.com/dkbnull/HelloUtil
 */
public class WebUtils {

    private static final String METHOD_POST = "POST";
    private static final String METHOD_GET = "GET";

    private static SSLSocketFactory sslSocketFactory = null;
    private static HostnameVerifier hostnameVerifier;

    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }

    static {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(new KeyManager[0], new TrustManager[]{new DefaultTrustManager()},
                    new SecureRandom());

            context.getClientSessionContext().setSessionTimeout(15);
            context.getClientSessionContext().setSessionCacheSize(1000);

            sslSocketFactory = context.getSocketFactory();
        } catch (Exception ignore) {

        }

        hostnameVerifier = (hostname, session) -> false;
    }

    private WebUtils() {
    }

    /**
     * 初始化SSL证书
     *
     * @param keyPathname   客户端证书路径
     * @param keyPassword   客户端证书密码
     * @param trustPathname 信任证书路径
     * @param trustPassword 信任证书密码
     * @throws Exception
     */
    public static void initSSLSocketFactory(String keyPathname, String keyPassword, String trustPathname,
                                            String trustPassword) throws Exception {
        sslSocketFactory = getSSLContext(keyPathname, keyPassword, trustPathname, trustPassword).getSocketFactory();
        hostnameVerifier = (hostname, session) -> true;
    }

    public static void setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
        WebUtils.sslSocketFactory = sslSocketFactory;
    }

    public static void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        WebUtils.hostnameVerifier = hostnameVerifier;
    }

    public static String doPost(String url, Map<String, Object> params) throws Exception {
        return doPost(url, buildParams(params, UtilConstants.CHARSET_UTF8), null, null,
                ContentType.APPLICATION_X_WWW_FORM_URLENCODED, ContentType.TEXT_HTML);
    }

    public static String doPost(String url, String content) throws Exception {
        return doPost(url, content, null, null, ContentType.APPLICATION_JSON, ContentType.APPLICATION_JSON);
    }

    public static String doPost(String url, String content, ContentType contentType, ContentType accept) throws Exception {
        return doPost(url, content, null, null, contentType, accept);
    }

    public static String doPost(String url, String content, ContentType contentType, ContentType accept,
                                Map<String, String> headers) throws Exception {
        return doPost(url, content, null, headers, contentType, accept);
    }

    public static String doPost(String url, String content, ContentType contentType, ContentType accept,
                                String token) throws Exception {
        return doPost(url, content, token, null, contentType, accept);
    }

    public static String doPost(String url, String content, String token, Map<String, String> headers,
                                ContentType contentType, ContentType accept) throws Exception {
        int connectTimeout = 60000;
        int readTimeout = 120000;

        return doPost(url, content, token, headers, contentType, accept, UtilConstants.CHARSET_UTF8,
                connectTimeout, readTimeout);
    }

    public static String doPost(String url, String content, String token, Map<String, String> headers,
                                ContentType contentType, ContentType accept, String charset,
                                int connectTimeout, int readTimeout) throws Exception {
        byte[] request = {};
        if (content != null) {
            request = content.getBytes(charset);
        }

        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        try {
            String contentTypeValue = contentType.toString() + ";charset=" + charset;
            String acceptValue = accept.toString();

            connection = getConnection(new URL(url), METHOD_POST, contentTypeValue, acceptValue, token, headers);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);

            outputStream = connection.getOutputStream();
            outputStream.write(request);

            return getResponseString(connection);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String doGet(String url, Map<String, Object> params) throws Exception {
        int connectTimeout = 60000;
        int readTimeout = 120000;

        return doGet(url, buildParams(params, UtilConstants.CHARSET_UTF8), null, null,
                ContentType.APPLICATION_X_WWW_FORM_URLENCODED, ContentType.TEXT_HTML,
                UtilConstants.CHARSET_UTF8, connectTimeout, readTimeout);
    }

    public static String doGet(String url, String content, ContentType contentType, ContentType accept) throws Exception {
        return doGet(url, content, null, null, contentType, accept);
    }

    public static String doGet(String url, String content, String token, Map<String, String> headers,
                               ContentType contentType, ContentType accept) throws Exception {
        int connectTimeout = 60000;
        int readTimeout = 120000;

        return doGet(url, content, token, headers, contentType, accept, UtilConstants.CHARSET_UTF8,
                connectTimeout, readTimeout);
    }

    /**
     * HTTP GET请求
     *
     * @param url            请求地址
     * @param content        请求参数
     * @param accept         Accept
     * @param contentType    Content-Type
     * @param charset        字符集
     * @param connectTimeout 请求超时时间
     * @param readTimeout    读取数据超时时间
     * @return 返回参数
     * @throws Exception
     */
    public static String doGet(String url, String content, String token, Map<String, String> headers, ContentType contentType,
                               ContentType accept, String charset, int connectTimeout, int readTimeout) throws Exception {
        HttpURLConnection connection = null;
        try {
            String contentTypeValue = contentType.toString() + ";charset=" + charset;
            String acceptValue = accept.toString();

            connection = getConnection(buildGetUrl(url, content), METHOD_GET, contentTypeValue, acceptValue, token, headers);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);

            return getResponseString(connection);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public static String buildParams(Map<String, Object> params) throws Exception {
        return buildParams(params, UtilConstants.CHARSET_UTF8);
    }

    public static String buildParams(Map<String, Object> params, String charset) throws Exception {
        if (MapUtils.isEmpty(params)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            if (StringUtils.areNotEmpty(key, value)) {
                if (hasParam) {
                    sb.append("&");
                } else {
                    hasParam = true;
                }

                sb.append(key).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return sb.toString();
    }

    private static HttpURLConnection getConnection(URL url, String method, String contentType, String accept, String token,
                                                   Map<String, String> headers) throws Exception {
        HttpURLConnection connection;
        if ("https".equalsIgnoreCase(url.getProtocol())) {
            HttpsURLConnection connectionHttps = (HttpsURLConnection) url.openConnection();
            connectionHttps.setSSLSocketFactory(sslSocketFactory);
            connectionHttps.setHostnameVerifier(hostnameVerifier);
            connection = connectionHttps;
        } else {
            connection = (HttpURLConnection) url.openConnection();
        }

        connection.setRequestMethod(method);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("Accept", accept);
        if (!StringUtils.isEmpty(token)) {
            connection.setRequestProperty("Authorization", token);
        }
        if (!MapUtils.isEmpty(headers)) {
            for (String key : headers.keySet()) {
                connection.setRequestProperty(key, headers.get(key));
            }
        }

        return connection;
    }

    private static SSLContext getSSLContext(String keyPathname, String keyPassword, String trustPathname,
                                            String trustPassword) throws Exception {
        KeyManager[] keyManagers;
        if (!StringUtils.isEmpty(keyPathname)) {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(getKeyStore("PKCS12", keyPathname, keyPassword), keyPassword.toCharArray());
            keyManagers = keyManagerFactory.getKeyManagers();
        } else {
            keyManagers = new KeyManager[0];
        }

        TrustManager[] trustManagers;
        if (!StringUtils.isEmpty(trustPathname)) {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(getKeyStore("JKS", trustPathname, trustPassword));
            trustManagers = trustManagerFactory.getTrustManagers();
        } else {
            trustManagers = new TrustManager[]{new DefaultTrustManager()};
        }

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagers, trustManagers, new SecureRandom());
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

        return sslContext;
    }

    private static KeyStore getKeyStore(String type, String pathname, String password) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(type);
            fileInputStream = new FileInputStream(new File(pathname));
            keyStore.load(fileInputStream, password.toCharArray());

            return keyStore;
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getResponseString(HttpURLConnection connection) throws Exception {
        String charset = getResponseCharset(connection.getContentType());
        InputStream inputStream = connection.getErrorStream();
        if (inputStream == null) {
            return getResponseString(connection.getInputStream(), charset);
        } else {
            String response = getResponseString(inputStream, charset);
            if (StringUtils.isEmpty(response)) {
                throw new IOException(connection.getResponseCode() + ":" + connection.getResponseMessage());
            } else {
                //throw new IOException(response);
                return response;
            }
        }
    }

    private static String getResponseString(InputStream inputStream, String charset) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char[256];
            int count;
            while ((count = bufferedReader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }

            return writer.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static String getResponseCharset(String contentType) {
        String charset = UtilConstants.CHARSET_UTF8;

        if (!StringUtils.isEmpty(contentType)) {
            String[] params = contentType.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtils.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

    private static URL buildGetUrl(String strUrl, String content) throws Exception {
        URL url = new URL(strUrl);

        if (StringUtils.isEmpty(content)) {
            return url;
        }

        if (StringUtils.isEmpty(url.getQuery())) {
            if (strUrl.endsWith("?")) {
                strUrl = strUrl + content;
            } else {
                strUrl = strUrl + "?" + content;
            }
        } else {
            if (strUrl.endsWith("&")) {
                strUrl = strUrl + content;
            } else {
                strUrl = strUrl + "&" + content;
            }
        }

        return new URL(strUrl);
    }
}
