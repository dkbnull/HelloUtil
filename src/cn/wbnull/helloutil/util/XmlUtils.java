package cn.wbnull.helloutil.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;
import org.dom4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * XML 工具类
 *
 * @author dukunbiao(null)  2018-07-26
 * https://github.com/dkbnull/HelloUtil
 */
@SuppressWarnings("all")
public class XmlUtils {

    private XmlUtils() {
    }

    /**
     * 检查String是否为XML格式
     *
     * @param value 待检查字符串
     * @return true/false
     */
    public static boolean isXml(String value) {
        try {
            DocumentHelper.parseText(value);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Map转XML，支持fastjson
     *
     * @param map  待转化Map
     * @param root 根节点
     * @return XML格式字符串
     */
    public static String mapToXml(Map<String, Object> map, String root) {
        return "<" + root + ">" +
                mapToXml(map) +
                "</" + root + ">";
    }

    public static String mapToXml(Map<String, Object> map, String root, String namespaces) {
        return "<" + root + " " + namespaces + ">" +
                mapToXml(map) +
                "</" + root + ">";
    }

    public static String mapToXml(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        for (String key : keys) {
            sb.append("<").append(key).append(">");
            sb.append(map.get(key));
            sb.append("</").append(key).append(">");
        }

        return sb.toString();
    }

    /**
     * Java Bean转XML
     *
     * @param object 待转化Java Bean
     * @return
     * @throws Exception XML格式字符串
     */
    public static String javaBeanToXmlByXStream(Object object) {
        XStream xStream = new XStream();
        xStream.processAnnotations(object.getClass());

        return xStream.toXML(object);
    }

    /**
     * Java Bean转XML
     *
     * @param object 待转化Java Bean
     * @param root   根节点
     * @return XML格式字符串
     */
    public static String javaBeanToXml(Object object, String root) {
        return mapToXml(JSONUtils.javaBeanToJSON(object), root);
    }

    public static String javaBeanToXml(Object object) {
        return mapToXml(JSONUtils.javaBeanToJSON(object));
    }

    /**
     * Java Bean转XML
     *
     * @param object     待转化Java Bean
     * @param root       根节点
     * @param namespaces 命名空间
     * @return XML格式字符串
     */
    public static String javaBeanToXml(Object object, String root, String namespaces) {
        return mapToXml(JSONUtils.javaBeanToJSON(object), root, namespaces);
    }

    /**
     * Map List转XML，支持fastjson
     *
     * @param maps      待转化Map List
     * @param root      根节点
     * @param childRoot 子节点
     * @return XML格式字符串
     */
    public static String mapsToXml(List<Map<String, Object>> maps, String root, String childRoot) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(root).append(">");
        for (Map<String, Object> map : maps) {
            sb.append(mapToXml(map, childRoot));
        }
        sb.append("</").append(root).append(">");

        return sb.toString();
    }

    /**
     * JSONArray转XML
     *
     * @param jsonArray 待转化JSONArray
     * @param root      根节点
     * @param childRoot 子节点
     * @return XML格式字符串
     */
    public static String jsonArrayToXml(JSONArray jsonArray, String root, String childRoot) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(root).append(">");
        for (Object object : jsonArray) {
            JSONObject jsonObject = JSONObject.parseObject(object.toString());
            sb.append(mapToXml(jsonObject, childRoot));
        }
        sb.append("</").append(root).append(">");

        return sb.toString();
    }

    /**
     * XML转JSON，支持Map<String, Object>接收
     *
     * @param xml 待转化XML
     * @return JSON
     * @throws Exception
     */
    public static JSONObject xmlToJSON(String xml) throws Exception {
        return elementToJSON(stringToDocument(xml).getRootElement());
    }

    /**
     * XML转 Java Bean
     *
     * @param xml
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T xmlToJavaBean(String xml, Class<T> clazz) throws Exception {
        return JSONObject.parseObject(xmlToJSON(xml).toString(), clazz);
    }

    /**
     * XML转 Java Bean
     *
     * @param xml
     * @param types
     * @param <T>
     * @return
     */
    @SuppressWarnings({"unchecked"})
    public static <T> T xmlToJavaBeanByXStream(String xml, Class[] types) {
        if (StringUtils.isEmpty(xml)) {
            return null;
        }

        XStream xStream = new XStream() {
            @Override
            protected MapperWrapper wrapMapper(MapperWrapper next) {
                return new MapperWrapper(next) {
                    @Override
                    public boolean shouldSerializeMember(Class definedIn, String fieldName) {
                        if (definedIn == Object.class) {
                            return false;
                        }
                        return super.shouldSerializeMember(definedIn, fieldName);
                    }
                };
            }
        };
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(types);
        xStream.processAnnotations(types);
        return (T) xStream.fromXML(xml);
    }

    private static Document stringToDocument(String xml) throws Exception {
        return DocumentHelper.parseText(xml);
    }

    @SuppressWarnings({"unchecked"})
    private static JSONObject elementToJSON(Element element) {
        JSONObject jsonObject = new JSONObject();
        List<Attribute> attributes = element.attributes();
        for (Attribute attribute : attributes) {
            jsonObject.put(attribute.getName(), attribute.getValue());
        }

        List<Element> elements = element.elements();
        if (!ListUtils.isEmpty(elements)) {
            for (Element e : elements) {
                if (e.attributes().isEmpty() && e.elements().isEmpty()) {
                    jsonObject.put(e.getName(), e.getTextTrim());
                } else {
                    if (!jsonObject.containsKey(e.getName())) {
                        jsonObject.put(e.getName(), new JSONArray());
                    }
                    ((JSONArray) jsonObject.get(e.getName())).add(elementToJSON(e));
                }
            }
        }

        return jsonObject;
    }

    /**
     * String型获取XML value值
     *
     * @param xml XML
     * @param key XML节点
     * @return value值
     * @throws Exception
     */
    public static String getXmlString(String xml, String key) throws Exception {
        if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(key)) {
            return "";
        }

        Document document = DocumentHelper.parseText(xml);
        return ((Element) (document.getRootElement().elements(key).get(0))).getText();
    }

    /**
     * int型获取XML value值
     *
     * @param xml XML
     * @param key XML节点
     * @return value值
     * @throws Exception
     */
    public static int getXmlInt(String xml, String key) throws Exception {
        if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(key)) {
            return 0;
        }

        return Integer.parseInt(getXmlString(xml, key));
    }

    /**
     * int型获取XML value值，无法转化则返回默认值
     *
     * @param xml          XML
     * @param key          XML节点
     * @param defaultValue 默认值
     * @return value值
     */
    public static int getXmlInt(String xml, String key, int defaultValue) {
        if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return Integer.parseInt(getXmlString(xml, key));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * double型获取XML value值
     *
     * @param xml XML
     * @param key XML节点
     * @return value值
     * @throws Exception
     */
    public static double getXmlDouble(String xml, String key) throws Exception {
        if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(key)) {
            return 0d;
        }

        return Double.parseDouble(getXmlString(xml, key));
    }

    /**
     * double型获取XML value值，无法转化则返回默认值
     *
     * @param xml          XML
     * @param key          XML节点
     * @param defaultValue 默认值
     * @return value值
     */
    public static double getXmlDouble(String xml, String key, double defaultValue) {
        if (StringUtils.isEmpty(xml) || StringUtils.isEmpty(key)) {
            return defaultValue;
        }

        try {
            return Double.parseDouble(getXmlString(xml, key));
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
