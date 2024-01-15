package cn.wbnull.helloutil.util;

import cn.wbnull.helloutil.constant.UtilConstants;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Date 工具类
 *
 * @author dukunbiao(null)  2018-08-31
 * https://github.com/dkbnull/HelloUtil
 */
public class DateUtils {

    private DateUtils() {
    }

    /**
     * 时间格式化
     *
     * @return 时间字符串
     */
    public static String dateFormat() {
        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(new Date());
    }

    public static String dateFormat(long timestamp) {
        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(new Date(timestamp));
    }

    public static String dateFormat(int timestamp) {
        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(new Date(timestamp * 1000L));
    }

    public static String dateFormat(int timestamp, String format) {
        return new SimpleDateFormat(format, Locale.CHINA).format(new Date(timestamp * 1000L));
    }

    public static String dateFormat(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(UtilConstants.DATE_FORMAT)).replace("T", " ");
    }

    /**
     * 时间格式化
     *
     * @param date 待格式化时间
     * @return 时间字符串
     */
    public static String dateFormat(Date date) {
        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(date);
    }

    /**
     * 时间格式化
     *
     * @param format 格式
     * @return 时间字符串
     */
    public static String dateFormat(String format) {
        if (StringUtils.isEmpty(format)) {
            return null;
        }

        return new SimpleDateFormat(format, Locale.CHINA).format(new Date());
    }

    /**
     * 时间格式化
     *
     * @param date   待格式化时间
     * @param format 格式
     * @return 时间字符串
     */
    public static String dateFormat(Date date, String format) {
        return new SimpleDateFormat(format, Locale.CHINA).format(date);
    }

    /**
     * 时间字符串格式化
     *
     * @param dateValue 待格式化时间字符串
     * @param toFormat  要格式化的格式
     * @return 时间字符串
     * @throws Exception
     */
    public static String dateFormat(String dateValue, String toFormat) throws Exception {
        if (StringUtils.isEmpty(dateValue) || StringUtils.isEmpty(toFormat)) {
            return null;
        }

        Date date = new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).parse(dateValue);
        return dateFormat(date, toFormat);
    }

    /**
     * 时间字符串格式化
     *
     * @param dateValue  待格式化时间字符串
     * @param fromFormat 待格式化时间字符串格式
     * @param toFormat   要格式化的格式
     * @return 时间字符串
     * @throws Exception
     */
    public static String dateFormat(String dateValue, String fromFormat, String toFormat) throws Exception {
        if (StringUtils.isEmpty(dateValue) || StringUtils.isEmpty(fromFormat) || StringUtils.isEmpty(toFormat)) {
            return null;
        }

        Date date = new SimpleDateFormat(fromFormat, Locale.CHINA).parse(dateValue);
        return dateFormat(date, toFormat);
    }

    public static String dateFormatCurrentTime(String currentTime) {
        if (StringUtils.isEmpty(currentTime)) {
            return currentTime;
        }

        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(new Date(Long.parseLong(currentTime) * 1000));
    }

    public static String dateFormatCurrentTimeMillis(String currentTime) {
        if (StringUtils.isEmpty(currentTime)) {
            return currentTime;
        }

        return new SimpleDateFormat(UtilConstants.DATE_FORMAT, Locale.CHINA).format(new Date(Long.parseLong(currentTime)));
    }

    public static Date dateParse(String dateValue) throws Exception {
        if (StringUtils.isEmpty(dateValue)) {
            return null;
        }

        return new SimpleDateFormat(UtilConstants.DATE_FORMAT).parse(dateValue);
    }

    public static Date dateParse(String dateValue, String fromFormat) throws Exception {
        if (StringUtils.isEmpty(dateValue) || StringUtils.isEmpty(fromFormat)) {
            return null;
        }

        return new SimpleDateFormat(fromFormat).parse(dateValue);
    }

    public static LocalDateTime localDateTimeParse(String dateValue) {
        if (StringUtils.isEmpty(dateValue)) {
            return null;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(UtilConstants.DATE_FORMAT);
        return LocalDateTime.parse(dateValue.replaceAll("T", " "), dtf);
    }

    public static LocalTime localTimeParse(String dateValue) {
        if (StringUtils.isEmpty(dateValue)) {
            return null;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(dateValue, dtf);
    }

    public static Date dateParse(String dateValue, String fromFormat, String toFormat) throws Exception {
        if (StringUtils.isEmpty(dateValue) || StringUtils.isEmpty(fromFormat) || StringUtils.isEmpty(toFormat)) {
            return null;
        }

        return dateParse(dateFormat(dateParse(dateValue, fromFormat), toFormat), toFormat);
    }

    /**
     * 获取Linux时间戳，精确到秒
     *
     * @return Linux时间戳
     */
    public static String currentTime() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long toEpochTime(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() / 1000;
    }

    public static LocalDateTime toLocalDateTime(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofHours(8));
    }
}
