package cn.wbnull.helloutil.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.*;

/**
 * JSON 工具类
 *
 * @author dukunbiao(null) 2018-07-26
 * https://github.com/dkbnull/HelloUtil
 */
@SuppressWarnings("all")
public class JSONUtils {

    private static final String WHITESPACE = "   ";

    private JSONUtils() {
    }

    /**
     * 检查JSON是否为空
     *
     * @param json 待检查JSON
     * @return true/false
     */
    public static boolean isEmpty(JSONObject json) {
        return (json == null || json.isEmpty());
    }

    /**
     * 检查JSONArray是否为空
     *
     * @param jsonArray 待检查JSONArray
     * @return true/false
     */
    public static boolean isEmpty(JSONArray jsonArray) {
        return ListUtils.isEmpty(jsonArray);
    }

    /**
     * String型获取JSON value值
     *
     * @param json JSON
     * @param key  key值
     * @return value值
     */
    public static String getJSONString(JSONObject json, String key) {
        return MapUtils.getMapString(json, key);
    }

    /**
     * int型获取JSON value值
     *
     * @param json JSON
     * @param key  key值
     * @return value值
     */
    public static int getJSONInt(JSONObject json, String key) {
        return MapUtils.getMapInt(json, key);
    }

    /**
     * int型获取JSON value值，无法转化则返回默认值
     *
     * @param json         JSON
     * @param key          key值
     * @param defaultValue 默认值
     * @return value值
     */
    public static int getJSONInt(JSONObject json, String key, int defaultValue) {
        return MapUtils.getMapInt(json, key, defaultValue);
    }

    /**
     * double型获取JSON value值
     *
     * @param json JSON
     * @param key  key值
     * @return value值
     */
    public static double getJSONDouble(JSONObject json, String key) {
        return MapUtils.getMapDouble(json, key);
    }

    /**
     * double型获取JSON value值，无法转化则返回默认值
     *
     * @param json         JSON
     * @param key          key值
     * @param defaultValue 默认值
     * @return value值
     */
    public static double getJSONDouble(JSONObject json, String key, double defaultValue) {
        return MapUtils.getMapDouble(json, key, defaultValue);
    }

    /**
     * Java Bean 转JSON
     *
     * @param object 待转化Java Bean
     * @return JSONObject
     */
    public static JSONObject javaBeanToJSON(Object object) {
        return JSONObject.parseObject(JSONObject.toJSONString(object), Feature.OrderedField);
    }

    public static <T> T convertJavaBean(Object object, Class<T> clazz) {
        return JSONObject.parseObject(JSONObject.toJSONString(object), clazz);
    }

    public static <T> List<T> convertJavaListBean(Object object, Class<T> clazz) {
        return JSONArray.parseArray(JSONArray.toJSONString(object), clazz);
    }

    /**
     * Java Bean 转JSONArray
     *
     * @param object 待转化Java Bean
     * @return JSONArray
     */
    public static JSONArray javaBeanToJSONArray(Object object) {
        return JSONArray.parseArray(JSONArray.toJSONString(object));
    }

    /**
     * JSON 转 Map
     *
     * @param json 待转化JSON
     * @return Map
     */
    public static Map<String, String> JSONToMap(JSONObject json) {
        Map<String, String> map = new HashMap<>(json.size());
        List<String> keys = new ArrayList<>(json.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            map.put(key, json.get(key).toString());
        }

        return map;
    }

    public static JSONObject mapToJSON(Map<String, String> map) {
        JSONObject json = new JSONObject();

        List<String> keys = new ArrayList<>(map.keySet());

        for (String key : keys) {
            json.put(key, map.get(key));
        }

        return json;
    }

    /**
     * 格式化JSON字符串，不校验JSON格式合法性
     *
     * @param value 待格式化JSON字符串
     * @return 格式化后JSON字符串
     */
    public static String JSONFormat(String value) {
        StringBuilder sb = new StringBuilder();

        int length = value.length();
        int number = 0;
        char key;

        for (int i = 0; i < length; i++) {
            key = value.charAt(i);

            if ((key == '[') || (key == '{')) {
                sb.append(key);
                sb.append('\n');

                number++;
                sb.append(indent(number));

                continue;
            }

            if ((key == ']') || (key == '}')) {
                sb.append('\n');

                number--;
                sb.append(indent(number));
                sb.append(key);

                if (((i + 1) < length) && (value.charAt(i + 1) != ',') &&
                        (value.charAt(i + 1) != '}') && (value.charAt(i + 1) != ']')) {
                    sb.append('\n');
                }

                continue;
            }

            if ((key == ',')) {
                sb.append(key);
                sb.append('\n');
                sb.append(indent(number));

                continue;
            }

            sb.append(key);
        }

        return sb.toString();
    }

    private static String indent(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(WHITESPACE);
        }

        return sb.toString();
    }
}
