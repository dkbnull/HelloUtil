package cn.wbnull.helloutil.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Axis 工具类
 *
 * @author dukunbiao(null)  2018-08-21
 * https://github.com/dkbnull/HelloUtil
 */
public class AxisUtils {

    private AxisUtils() {
    }

    /**
     * 调用 WebService 服务
     *
     * @param url       请求地址
     * @param namespace 命名空间
     * @param method    接口方法
     * @param params    请求参数
     * @param timeout   超时时间
     * @return
     * @throws Exception
     */
    public static String callWebService(String url, String namespace, String method, JSONObject params, int timeout) throws Exception {
        return callWebService(url, namespace, method, namespace + method, params, timeout, String.class);
    }

    /**
     * 调用 WebService 服务
     *
     * @param url       请求地址
     * @param namespace 命名空间
     * @param method    接口方法
     * @param params    请求参数
     * @param clazz     返回参数类型
     * @param <T>       接收参数类型
     * @throws Exception
     */
    public static <T> T callWebService(String url, String namespace, String method, JSONObject params, Class<T> clazz) throws Exception {
        return callWebService(url, namespace, method, null, params, 60000, clazz);
    }

    /**
     * 调用 WebService 服务
     *
     * @param url       请求地址
     * @param namespace 命名空间
     * @param method    接口方法
     * @param actionUri SOAPActionURI
     * @param params    请求参数
     * @param timeout   超时时间
     * @param clazz     返回参数类型
     * @param <T>       接收参数类型
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T callWebService(String url, String namespace, String method, String actionUri, JSONObject params, int timeout, Class<T> clazz) throws Exception {
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(url);
        call.setOperationName(new QName(namespace, method));
        if (!StringUtils.isEmpty(actionUri)) {
            call.setSOAPActionURI(actionUri);
        }
        call.setTimeout(timeout);

        List<String> keys = new ArrayList<>(params.keySet());
        String[] values = new String[params.size()];
        for (int i = 0; i < params.size(); i++) {
            call.addParameter(new QName(namespace, keys.get(i)), XMLType.XSD_STRING, ParameterMode.IN);
            values[i] = params.get(keys.get(i)).toString();
        }

        call.registerTypeMapping(clazz,
                new QName(namespace, method),
                new BeanSerializerFactory(clazz, new QName(namespace, method)),
                new BeanDeserializerFactory(clazz, new QName(namespace, method)));
        if (!StringUtils.isEmpty(actionUri)) {
            call.setUseSOAPAction(true);
        }

        if (clazz.getName().contains("java.lang.String")) {
            call.setReturnType(XMLType.XSD_STRING);
        } else {
            call.setReturnClass(clazz);
        }

        return (T) call.invoke(values);
    }
}
