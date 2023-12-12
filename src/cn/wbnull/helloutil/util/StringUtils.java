package cn.wbnull.helloutil.util;

import cn.wbnull.helloutil.constant.UtilConstants;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * String 工具类
 *
 * @author dukunbiao(null)  2018-07-26
 * https://github.com/dkbnull/HelloUtil
 */
public class StringUtils {

    public static final String STRING_TYPE_RIGHT = "R";
    public static final String STRING_TYPE_LEFT = "L";

    private static final String DIGITS = "0123456789abcdef";
    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random RANDOM = new SecureRandom();

    private static final Pattern PATTERN_NUMERIC = Pattern.compile("-?[0-9]*+.?[0-9]*");
    private static final Pattern PATTERN_INTEGER = Pattern.compile("-?[0-9]*");
    private static final Pattern PATTERN_PHONE = Pattern.compile("^[1]\\d{10}$");
    private static final Pattern PATTERN_PHS = Pattern.compile("\\d{8}$");

    private StringUtils() {
    }

    /**
     * 检查指定字符串是否为空
     * StringUtils.isEmpty(null) = true
     * StringUtils.isEmpty("") = true
     * StringUtils.isEmpty("   ") = true
     * StringUtils.isEmpty("abc") = false
     *
     * @param value 待检查字符串
     * @return true/false
     */
    public static boolean isEmpty(String value) {
        int length;
        if (value == null || (length = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查指定字符串列表是否不为空
     *
     * @param values 待检查字符串列表
     * @return true/false
     */
    public static boolean areNotEmpty(String... values) {
        if (values == null || values.length == 0) {
            return false;
        }

        boolean result = true;
        for (String value : values) {
            result &= !isEmpty(value);
        }
        return result;
    }

    /**
     * 检查String是否为数值型字符串，包含整数、小数
     *
     * @param value 待检查字符串
     * @return true/false
     */
    public static boolean isNumeric(String value) {
        return (!isEmpty(value)) && PATTERN_NUMERIC.matcher(value).matches();
    }

    /**
     * 检查String是否是int型字符串
     *
     * @param value 待检查字符串
     * @return true/false
     */
    public static boolean isInteger(String value) {
        return (!isEmpty(value)) && PATTERN_INTEGER.matcher(value).matches();
    }

    public static boolean isPhone(String value) {
        return (!isEmpty(value)) && PATTERN_PHONE.matcher(value).matches();
    }

    public static boolean isPhs(String value) {
        return (!isEmpty(value)) && PATTERN_PHS.matcher(value).matches();
    }

    /**
     * 按要求截取指定长度字符串
     *
     * @param value      待截取字符串
     * @param beginIndex 起始位置
     * @param endIndex   结束位置
     * @return 截取后字符串
     */
    public static String substringValue(String value, int beginIndex, int endIndex) {
        if (isEmpty(value)) {
            return "";
        }

        if (beginIndex < 0) {
            beginIndex = 0;
        }
        if (endIndex > value.length()) {
            endIndex = value.length();
        }
        if (endIndex - beginIndex < 0) {
            return "";
        }

        return value.substring(beginIndex, endIndex);
    }

    /**
     * 按要求截取指定长度字符串，不足则返回完整字符串
     *
     * @param value  待截取字符串
     * @param length 截取长度
     * @param tag    R 右截取   L 左截取
     * @return 截取后字符串
     */
    public static String substringValue(String value, int length, String tag) {
        if (isEmpty(value)) {
            return "";
        }

        if (value.length() <= length) {
            return value;
        }

        if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
            return value.substring(0, length);
        } else if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
            return value.substring(value.length() - length);
        } else {
            return value;
        }
    }

    public static String substringValue(String value, int length, String tag, String charset) {
        if (isEmpty(value)) {
            return "";
        }

        try {
            if (value.getBytes(charset).length <= length) {
                return value;
            }
        } catch (UnsupportedEncodingException ignore) {

        }

        StringBuilder sb = new StringBuilder();

        if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
            while (length > 0) {
                String valueChar = value.substring(0, 1);
                value = value.substring(1);
                int lengthValue;
                try {
                    lengthValue = valueChar.getBytes(charset).length;
                } catch (UnsupportedEncodingException e) {
                    lengthValue = value.length();
                }
                //是汉字
                if (lengthValue == 2) {
                    if (length >= 2) {
                        sb.append(valueChar);
                    } else {
                        sb.append(" ");
                    }
                } else {
                    sb.append(valueChar);
                }

                length = length - lengthValue;
            }
        } else {
            while (length > 0) {
                String valueChar = value.substring(value.length() - 1);
                value = value.substring(0, value.length() - 1);
                int lengthValue;
                try {
                    lengthValue = valueChar.getBytes(charset).length;
                } catch (UnsupportedEncodingException e) {
                    lengthValue = value.length();
                }
                //是汉字
                if (lengthValue == 2) {
                    if (length >= 2) {
                        sb.insert(0, valueChar);
                    } else {
                        sb.insert(0, " ");
                    }
                } else {
                    sb.insert(0, valueChar);
                }

                length = length - lengthValue;
            }
        }

        return sb.toString();
    }

    /**
     * 获取指定长度随机字符串
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String random(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((new Random().nextInt(10)));
        }

        return sb.toString();
    }

    /**
     * 获取指定长度随机字符串（数字、字母）
     *
     * @param length 随机字符串长度
     * @return
     */
    public static String randomNonce(int length) {
        char[] nonceChars = new char[length];
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }

        return new String(nonceChars);
    }

    /**
     * String转int，格式不正确则返回默认值
     *
     * @param value        字符串
     * @param defaultValue 默认值
     * @return 数值
     */
    public static int toInt(String value, int defaultValue) {
        if ((!isEmpty(value)) && (isInteger(value))) {
            return Integer.parseInt(value);
        }

        return defaultValue;
    }

    /**
     * String转long，格式不正确则返回默认值
     *
     * @param value        字符串
     * @param defaultValue 默认值
     * @return 数值
     */
    public static long toLong(String value, long defaultValue) {
        if ((!isEmpty(value)) && (isInteger(value))) {
            return Long.parseLong(value);
        }

        return defaultValue;
    }

    /**
     * String转double，格式不正确则返回默认值
     *
     * @param value        字符串
     * @param defaultValue 默认值
     * @return 数值
     */
    public static double toDouble(String value, double defaultValue) {
        if ((!isEmpty(value)) && (isNumeric(value))) {
            return Double.parseDouble(value);
        }

        return defaultValue;
    }

    /**
     * 获取16进制字符串
     *
     * @param value 待转化数据
     * @return 16进制字符串
     */
    public static String toHex(String value) {
        return byteToHex(value.getBytes());
    }

    /**
     * 获取16进制字符串
     *
     * @param data 待转化数据
     * @return 16进制字符串
     */
    public static String byteToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();

        for (byte byt : data) {
            int v = byt & 0xff;

            sb.append(DIGITS.charAt(v >> 4));
            sb.append(DIGITS.charAt(v & 0xf));
        }

        return sb.toString();
    }

    /**
     * 16进制字符串转String
     *
     * @param value 16进制字符串
     * @return 转换后字符串
     */
    public static String hexToString(String value) {
        return new String(hexToByte(value));
    }

    /**
     * 获取UTF-8编码格式字符串
     *
     * @param value 待转化字符串
     * @return UTF-8编码格式字符串
     * @throws Exception
     */
    public static String toUTF8String(String value) throws Exception {
        return new String(value.getBytes(UtilConstants.CHARSET_GB2312), StandardCharsets.UTF_8);
    }

    /**
     * 获取UTF-8编码格式字符串
     *
     * @param value       待转化字符串
     * @param fromCharset 待转化字符串字符集
     * @return 转换后字符串
     * @throws Exception
     */
    public static String toUTF8String(String value, String fromCharset) throws Exception {
        return new String(value.getBytes(fromCharset), StandardCharsets.UTF_8);
    }

    /**
     * 获取指定编码格式字符串
     *
     * @param value       待转化字符串
     * @param fromCharset 待转化字符串字符集
     * @param toCharset   转化后字符串字符集
     * @return 转换后字符串
     * @throws Exception
     */
    public static String toCharsetString(String value, String fromCharset, String toCharset) throws Exception {
        return new String(value.getBytes(fromCharset), toCharset);
    }

    /**
     * 16进制字符串转byte
     *
     * @param value 16进制字符串
     * @return byte
     */
    public static byte[] hexToByte(String value) {
        int m, n;
        int l = value.length() / 2;
        byte[] bytes = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            bytes[i] = uniteBytes(value.substring(i * 2, m), value.substring(m, n));
        }
        return bytes;
    }

    private static byte uniteBytes(String value0, String value1) {
        byte b0 = Byte.decode("0x" + value0);
        b0 = (byte) (b0 << 4);
        byte b1 = Byte.decode("0x" + value1);
        return (byte) (b0 | b1);
    }

    /**
     * 字符串补空格，字符串长度大于补全后长度则截取字符串
     *
     * @param value  待补全字符串
     * @param length 补全后长度
     * @param tag    R 右补全   L 左补全
     * @return 补全后字符串
     */
    public static String stringPadding(String value, int length, String tag) {
        if (isEmpty(value)) {
            value = "";
        }
        if (length <= 0) {
            return value;
        }

        int lengthValue;
        try {
            lengthValue = value.getBytes(UtilConstants.CHARSET_GBK).length;
        } catch (UnsupportedEncodingException e) {
            lengthValue = value.length();
        }

        if (lengthValue == length) {
            return value;
        }

        if (lengthValue > length) {
            if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_LEFT, UtilConstants.CHARSET_GBK);
            } else if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_RIGHT, UtilConstants.CHARSET_GBK);
            } else {
                return value;
            }
        }

        length = length - (lengthValue - value.length());
        String padFormat;
        if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
            padFormat = "%" + length + "s";
        } else if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
            padFormat = "%-" + length + "s";
        } else {
            padFormat = "%s";
        }

        return String.format(padFormat, value);
    }

    /**
     * 字符串补空格，字符串长度大于补全后长度则截取字符串
     *
     * @param value   待补全字符串
     * @param length  补全后长度
     * @param tag     R 右补全   L 左补全
     * @param charset 字符集
     * @return 补全后字符串
     */
    public static String stringPadding(String value, int length, String tag, String charset) {
        if (isEmpty(value)) {
            value = "";
        }
        if (length <= 0) {
            return value;
        }

        if (value.length() >= length) {
            if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_LEFT);
            } else if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_RIGHT);
            } else {
                return value;
            }
        }

        try {
            int lengthValue = value.getBytes(charset).length;
            length = length - (lengthValue - value.length());
        } catch (UnsupportedEncodingException ignore) {

        }

        String padFormat;
        if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
            padFormat = "%" + length + "s";
        } else if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
            padFormat = "%-" + length + "s";
        } else {
            padFormat = "%s";
        }

        return String.format(padFormat, value);
    }

    /**
     * 字符串补全，字符串长度大于补全后长度则截取字符串
     *
     * @param value   待补全字符串
     * @param length  补全后长度
     * @param fill    填充字符
     * @param tag     R 右补全   L 左补全
     * @param charset 字符集
     * @return 补全后字符串
     */
    public static String stringPadding(String value, int length, String fill, String tag, String charset) {
        if (isEmpty(value)) {
            value = "";
        }
        if (length <= 0) {
            return value;
        }

        if (value.length() >= length) {
            if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_LEFT);
            } else if (STRING_TYPE_LEFT.equalsIgnoreCase(tag)) {
                return substringValue(value, length, STRING_TYPE_RIGHT);
            } else {
                return value;
            }
        }

        int lengthValue = 0;
        try {
            lengthValue = value.getBytes(charset).length;
        } catch (UnsupportedEncodingException ignore) {

        }

        StringBuilder res = new StringBuilder();
        StringBuilder bf = new StringBuilder(value);

        if (STRING_TYPE_RIGHT.equalsIgnoreCase(tag)) {
            for (int i = 0; i < length - lengthValue; i++) {
                res = bf.append(fill);
            }
        } else if (STRING_TYPE_LEFT.equals(tag)) {
            StringBuilder bf1 = new StringBuilder();
            for (int i = 0; i < length - lengthValue; i++) {
                res = bf1.append(fill);
            }
            res.append(bf);
        } else {
            res = bf;
        }

        return res.toString();
    }

    public static String join(List<String> values) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String value : values) {
            sb.append("'").append(value).append("'").append(",");
        }
        sb.deleteCharAt(sb.length() - 1).append(")");
        return sb.toString();
    }

    public static String join(List<String> values, String separator) {
        if (ListUtils.isEmpty(values)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(value).append(separator);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 分转元
     *
     * @param value 金额，分
     * @return 金额，元
     */
    public static String formatF2Y(String value) {
        if (isEmpty(value)) {
            return "0.00";
        }

        return BigDecimalUtils.divide(value, "100", 2);
    }

    public static String formatF2Y(int value) {
        return formatF2Y(String.valueOf(value));
    }

    /**
     * 元转分
     *
     * @param value 金额，元
     * @return 金额，分
     */
    public static String formatY2F(String value) {
        if (isEmpty(value)) {
            return "0";
        }

        return BigDecimalUtils.multiply(value, "100", 0, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 克转千克
     *
     * @param value 重量，克
     * @return 重量，千克
     */
    public static String formatG2Kg(String value) {
        if (isEmpty(value)) {
            return "0";
        }

        return BigDecimalUtils.divide(value, "1000", 3);
    }

    /**
     * 千克转克
     *
     * @param value 重量，千克
     * @return 重量，克
     */
    public static String formatKg2G(String value) {
        if (isEmpty(value)) {
            return "0";
        }

        return BigDecimalUtils.multiply(value, "1000", 0, BigDecimal.ROUND_HALF_UP);
    }

    public static String format(String value) {
        if (value == null) {
            return "";
        }

        return value;
    }
}
