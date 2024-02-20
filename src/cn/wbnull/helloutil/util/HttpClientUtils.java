package cn.wbnull.helloutil.util;

import cn.wbnull.helloutil.constant.UtilConstants;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.Map;

/**
 * HttpClient 工具类
 *
 * @author dukunbiao(null)  2023-09-06
 * https://github.com/dkbnull/HelloUtil
 */
public class HttpClientUtils {

    public static String doPost(String url, JSONObject params, String contentType, String token) throws Exception {
        return doPost(url + "?" + WebUtils.buildParams(params), null, contentType, token, null,
                UtilConstants.CHARSET_UTF8);
    }

    public static String doPost(String url, String content, String contentType, String token) throws Exception {
        return doPost(url, content, contentType, token, null, UtilConstants.CHARSET_UTF8);
    }

    public static String doPost(String url, String content, String contentType, String token, Map<String, String> headers,
                                String charset) throws Exception {
        BasicHttpClientConnectionManager conn = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build(), null, null, null);
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(conn)
                .build();

        HttpPost httpPost = new HttpPost(url);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(60000)
                .setSocketTimeout(120000)
                .build();
        httpPost.setConfig(requestConfig);

        if (content != null) {
            StringEntity postEntity = new StringEntity(content, charset);
            httpPost.setEntity(postEntity);
        }

        httpPost.addHeader("Content-Type", contentType);
        if (token != null) {
            httpPost.addHeader("Authorization", token);
        }
        if (!MapUtils.isEmpty(headers)) {
            for (String key : headers.keySet()) {
                httpPost.addHeader(key, headers.get(key));
            }
        }

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();

        return EntityUtils.toString(httpEntity, charset);
    }
}
