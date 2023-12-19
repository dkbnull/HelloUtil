package cn.wbnull.helloutil.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * BigDecimal 工具类
 *
 * @author dukunbiao(null)  2019-03-29
 * https://github.com/dkbnull/HelloUtil
 */
public class BigDecimalUtils {

    private BigDecimalUtils() {
    }

    /**
     * 加
     *
     * @param value1 加数
     * @param value2 加数
     * @return 和
     */
    public static int add(int value1, int value2) {
        return BigDecimal.valueOf(value1).add(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    /**
     * 加
     *
     * @param value1 加数
     * @param value2 加数
     * @return 和
     */
    public static double add(double value1, double value2) {
        return BigDecimal.valueOf(value1).add(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    /**
     * 加
     *
     * @param value1 加数
     * @param value2 加数
     * @return 和
     */
    public static String add(String value1, String value2) {
        if (StringUtils.isEmpty(value1)) {
            value1 = "0";
        }
        if (StringUtils.isEmpty(value2)) {
            value2 = "0";
        }

        return new BigDecimal(value1).add(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String adds(String... values) {
        String result = "0";
        for (String value : values) {
            result = add(result, value);
        }
        return result;
    }

    public static String add(BigDecimal value1, String value2) {
        return value1.add(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String add(String value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = "0";
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return new BigDecimal(value1).add(value2).stripTrailingZeros().toPlainString();
    }

    public static String add(BigDecimal value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = new BigDecimal("0");
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return value1.add(value2).stripTrailingZeros().toPlainString();
    }

    public static String addFormat(String value1, String value2) {
        if (StringUtils.isEmpty(value1)) {
            value1 = "0";
        }
        if (StringUtils.isEmpty(value2)) {
            value2 = "0";
        }

        return format2Decimal(new BigDecimal(value1).add(new BigDecimal(value2)));
    }

    public static String addFormat(BigDecimal value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = new BigDecimal("0");
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return format2Decimal(value1.add(value2));
    }

    public static String addFormat(String value1, BigDecimal value2) {
        return format2Decimal(new BigDecimal(value1).add(value2));
    }

    /**
     * 减
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 差
     */
    public static int subtract(int value1, int value2) {
        return BigDecimal.valueOf(value1).subtract(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    /**
     * 减
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 差
     */
    public static double subtract(double value1, double value2) {
        return BigDecimal.valueOf(value1).subtract(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    public static long subtract(long value1, long value2) {
        return BigDecimal.valueOf(value1).subtract(BigDecimal.valueOf(value2)).stripTrailingZeros().longValue();
    }

    /**
     * 减
     *
     * @param value1 被减数
     * @param value2 减数
     * @return 差
     */
    public static String subtract(String value1, String value2) {
        return new BigDecimal(value1).subtract(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String subtract(BigDecimal value1, String value2) {
        return value1.subtract(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String subtract(String value1, BigDecimal value2) {
        return new BigDecimal(value1).subtract(value2).stripTrailingZeros().toPlainString();
    }

    public static String subtract(BigDecimal value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = new BigDecimal("0");
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return value1.subtract(value2).stripTrailingZeros().toPlainString();
    }

    public static String subtractFormat(String value1, String value2) {
        if (StringUtils.isEmpty(value1)) {
            value1 = "0";
        }
        if (StringUtils.isEmpty(value2)) {
            value2 = "0";
        }
        return format2Decimal(new BigDecimal(value1).subtract(new BigDecimal(value2)));
    }

    public static String subtractFormat(BigDecimal value1, BigDecimal value2) {
        return format2Decimal(value1.subtract(value2));
    }

    public static int subtractToInt(String value1, String value2) {
        return new BigDecimal(value1).subtract(new BigDecimal(value2)).stripTrailingZeros().intValue();
    }

    public static BigDecimal subtractFormatBigDecimal(String value1, String value2) {
        return new BigDecimal(value1).subtract(new BigDecimal(value2));
    }

    /**
     * 乘
     *
     * @param value1 乘数
     * @param value2 乘数
     * @return 积
     */
    public static int multiply(int value1, int value2) {
        return BigDecimal.valueOf(value1).multiply(BigDecimal.valueOf(value2)).stripTrailingZeros().intValue();
    }

    /**
     * 乘
     *
     * @param value1 乘数
     * @param value2 乘数
     * @return 积
     */
    public static double multiply(double value1, double value2) {
        return BigDecimal.valueOf(value1).multiply(BigDecimal.valueOf(value2)).stripTrailingZeros().doubleValue();
    }

    /**
     * 乘
     *
     * @param value1 乘数
     * @param value2 乘数
     * @return 积
     */
    public static String multiply(String value1, String value2) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String multiply(String value1, BigDecimal value2) {
        return new BigDecimal(value1).multiply(value2).stripTrailingZeros().toPlainString();
    }

    public static String multiply(BigDecimal value1, String value2) {
        return value1.multiply(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static BigDecimal multiplyDecimal(BigDecimal value1, String value2) {
        return value1.multiply(new BigDecimal(value2));
    }

    public static BigDecimal multiplyFormatDecimal(BigDecimal value1, String value2) {
        return value1.multiply(new BigDecimal(value2)).setScale(2, RoundingMode.HALF_UP);
    }

    public static String multiplyFormat(String value1, String value2) {
        if (StringUtils.isEmpty(value1)) {
            value1 = "0";
        }
        if (StringUtils.isEmpty(value2)) {
            value2 = "0";
        }
        return format2Decimal(new BigDecimal(value1).multiply(new BigDecimal(value2)));
    }

    public static String multiplyFormat(BigDecimal value1, String value2) {
        return format2Decimal(value1.multiply(new BigDecimal(value2)));
    }

    public static String multiplyNoFormat(String value1, String value2) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static String multiplyNoFormat(BigDecimal value1, String value2) {
        return value1.multiply(new BigDecimal(value2)).stripTrailingZeros().toPlainString();
    }

    public static BigDecimal multiplyFormatDecimal(String value1, String value2) {
        return new BigDecimal(format2Decimal(new BigDecimal(value1).multiply(new BigDecimal(value2))));
    }

    public static double multiplyFormatDouble(String value1, String value2) {
        return Double.parseDouble(format2Decimal(new BigDecimal(value1).multiply(new BigDecimal(value2))));
    }

    public static double multiplyFormatDouble(BigDecimal value1, String value2) {
        return Double.parseDouble(format2Decimal(value1.multiply(new BigDecimal(value2))));
    }

    public static BigDecimal multiplyNoFormatDecimal(String value1, String value2) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2));
    }

    public static BigDecimal multiplyNoFormatDecimal(BigDecimal value1, String value2) {
        return value1.multiply(new BigDecimal(value2));
    }

    public static String multiply(BigDecimal value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = new BigDecimal("0");
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return value1.multiply(value2).stripTrailingZeros().toPlainString();
    }

    /**
     * 乘
     *
     * @param value1       乘数
     * @param value2       乘数
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 积
     */
    public static double multiply(double value1, double value2, int scale, int roundingMode) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    /**
     * 乘
     *
     * @param value1       乘数
     * @param value2       乘数
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 积
     */
    public static String multiply(String value1, String value2, int scale, int roundingMode) {
        return new BigDecimal(value1).multiply(new BigDecimal(value2)).setScale(scale, roundingMode).stripTrailingZeros().toPlainString();
    }

    public static String divideFormat(double value1, double value2) {
        return format2Decimal(new BigDecimal(value1).divide(new BigDecimal(value2), 2, RoundingMode.HALF_UP));
    }

    public static String divideFormat(String value1, String value2) {
        return format2Decimal(new BigDecimal(value1).divide(new BigDecimal(value2), 2, RoundingMode.HALF_UP));
    }

    public static String divideFormat(BigDecimal value1, String value2) {
        return format2Decimal(value1.divide(new BigDecimal(value2), 2, RoundingMode.HALF_UP));
    }

    public static String divideFormat(BigDecimal value1, BigDecimal value2) {
        return format2Decimal(value1.divide(value2, 2, RoundingMode.HALF_UP));
    }

    public static String divideFormat(String value1, String value2, int scale) {
        return format2Decimal(new BigDecimal(value1).divide(new BigDecimal(value2), scale, RoundingMode.HALF_UP));
    }

    /**
     * 除
     *
     * @param value1       被除数
     * @param value2       除数
     * @param roundingMode 舍入模式
     * @return 商
     */
    public static double divide(int value1, int value2, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), roundingMode).stripTrailingZeros().doubleValue();
    }

    /**
     * 除
     *
     * @param value1       被除数
     * @param value2       除数
     * @param roundingMode 舍入模式
     * @return 商
     */
    public static double divide(double value1, double value2, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), roundingMode).stripTrailingZeros().doubleValue();
    }

    /**
     * 除
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精度
     * @return 商
     */
    public static String divide(String value1, String value2, int scale) {
        return new BigDecimal(value1).divide(new BigDecimal(value2), scale, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static String divide(BigDecimal value1, BigDecimal value2, int scale) {
        return value1.divide(value2, scale, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
    }

    public static BigDecimal divideFormatDecimal(String value1, String value2) {
        return new BigDecimal(format2Decimal(new BigDecimal(value1).divide(new BigDecimal(value2), 2, RoundingMode.HALF_UP)));
    }

    public static BigDecimal divideFormatDecimal(BigDecimal value1, BigDecimal value2) {
        return new BigDecimal(format2Decimal(value1.divide(value2, 2, RoundingMode.HALF_UP)));
    }

    public static BigDecimal divideFormatDecimal(BigDecimal value1, BigDecimal value2, int scale) {
        return new BigDecimal(format2Decimal(value1.divide(value2, scale, RoundingMode.HALF_UP)));
    }

    /**
     * 除
     *
     * @param value1       被除数
     * @param value2       除数
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 商
     */
    public static double divide(int value1, int value2, int scale, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    /**
     * 除
     *
     * @param value1       被除数
     * @param value2       除数
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 商
     */
    public static double divide(double value1, double value2, int scale, int roundingMode) {
        return BigDecimal.valueOf(value1).divide(BigDecimal.valueOf(value2), scale, roundingMode).stripTrailingZeros().doubleValue();
    }

    /**
     * 除
     *
     * @param value1       被除数
     * @param value2       除数
     * @param scale        精度
     * @param roundingMode 舍入模式
     * @return 商
     */
    public static String divide(String value1, String value2, int scale, int roundingMode) {
        return new BigDecimal(value1).divide(new BigDecimal(value2), scale, roundingMode).stripTrailingZeros().toPlainString();
    }

    public static String divide(String value1, BigDecimal value2, int scale, int roundingMode) {
        return new BigDecimal(value1).divide(value2, scale, roundingMode).stripTrailingZeros().toPlainString();
    }

    public static String remainder(String value1, String value2) {
        return new BigDecimal(value1).divideAndRemainder(new BigDecimal(value2))[1].toPlainString();
    }

    /**
     * 数值格式化
     *
     * @param value 待格式化数值
     * @return 格式化后数值
     */
    public static double format(double value) {
        return BigDecimal.valueOf(value).stripTrailingZeros().doubleValue();
    }

    /**
     * 数值格式化
     *
     * @param value 待格式化数值
     * @return 格式化后数值
     */
    public static String format(String value) {
        return new BigDecimal(value).stripTrailingZeros().toPlainString();
    }

    public static BigDecimal formatBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (Exception e) {
            return new BigDecimal("0");
        }
    }

    public static String format(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0");
        }

        return value.stripTrailingZeros().toPlainString();
    }

    public static String formatIfNull(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0");
        }

        return value.stripTrailingZeros().toPlainString();
    }

    public static String format2Decimal(BigDecimal value) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value.stripTrailingZeros().doubleValue());
    }

    public static String format2Decimal(double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(new BigDecimal(value).stripTrailingZeros().doubleValue());
    }

    public static String format2Decimal(String value) {
        if (StringUtils.isEmpty(value)) {
            value = "0";
        }

        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(new BigDecimal(value).stripTrailingZeros().doubleValue());
    }

    public static String format3Decimal(String value) {
        if (StringUtils.isEmpty(value)) {
            value = "0";
        }

        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(new BigDecimal(value).stripTrailingZeros().doubleValue());
    }

    public static String format0Decimal(String value) {
        if (StringUtils.isEmpty(value)) {
            value = "0";
        }

        DecimalFormat df = new DecimalFormat("0");
        return df.format(new BigDecimal(value).stripTrailingZeros().doubleValue());
    }

    public static String format2DecimalIfNull(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0");
        }

        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value.stripTrailingZeros().doubleValue());
    }

    /**
     * 比较大小
     *
     * @param value1
     * @param value2
     * @return -1:<, 0:=, 1:>
     */
    public static int compareTo(double value1, double value2) {
        return BigDecimal.valueOf(value1).compareTo(BigDecimal.valueOf(value2));
    }

    /**
     * 比较大小
     *
     * @param value1
     * @param value2
     * @return -1:<, 0:=, 1:>
     */
    public static int compareTo(String value1, String value2) {
        if (StringUtils.isEmpty(value1)) {
            value1 = "0";
        }
        if (StringUtils.isEmpty(value2)) {
            value2 = "0";
        }
        BigDecimal bigDecimal1;
        try {
            bigDecimal1 = new BigDecimal(value1);
        } catch (Exception e) {
            bigDecimal1 = new BigDecimal(0);
        }
        BigDecimal bigDecimal2;
        try {
            bigDecimal2 = new BigDecimal(value2);
        } catch (Exception e) {
            bigDecimal2 = new BigDecimal(0);
        }

        return bigDecimal1.compareTo(bigDecimal2);
    }

    public static int compareTo(String value1, BigDecimal value2) {
        return new BigDecimal(value1).compareTo(value2);
    }

    public static boolean isGreater(double value1, double value2) {
        return compareTo(value1, value2) > 0;
    }

    public static boolean isGreater(String value1, String value2) {
        return compareTo(value1, value2) > 0;
    }

    public static boolean isGreaterAndEqual(String value1, String value2) {
        return compareTo(value1, value2) >= 0;
    }

    public static boolean isGreater(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) > 0;
    }

    public static boolean isGreater(String value1, BigDecimal value2) {
        return compareTo(value1, value2) > 0;
    }

    public static boolean isEqual(String value1, String value2) {
        return compareTo(value1, value2) == 0;
    }

    public static boolean isEqual(String value1, BigDecimal value2) {
        return new BigDecimal(value1).compareTo(value2) == 0;
    }

    public static boolean isEqual(BigDecimal value1, BigDecimal value2) {
        if (value1 == null) {
            value1 = new BigDecimal("0");
        }
        if (value2 == null) {
            value2 = new BigDecimal("0");
        }

        return value1.compareTo(value2) == 0;
    }

    public static boolean isLess(double value1, double value2) {
        return compareTo(value1, value2) < 0;
    }

    public static boolean isLess(String value1, String value2) {
        return compareTo(value1, value2) < 0;
    }

    public static boolean isLessAndEqual(String value1, String value2) {
        return compareTo(value1, value2) <= 0;
    }

    public static boolean isLessAndEqual0(String value1) {
        return compareTo(value1, "0") <= 0;
    }

    public static boolean isLess(String value1, BigDecimal value2) {
        return compareTo(value1, value2) < 0;
    }

    public static boolean isLess(BigDecimal value1, BigDecimal value2) {
        return value1.compareTo(value2) < 0;
    }

    public static boolean isGreater0(String value) {
        return compareTo(value, "0") > 0;
    }

    public static boolean isGreater0(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0");
        }

        return value.compareTo(new BigDecimal("0")) > 0;
    }

    public static boolean isEqual0(double value) {
        return compareTo(value, 0) == 0;
    }

    public static boolean isEqual0(String value) {
        return compareTo(value, "0") == 0;
    }

    public static boolean isEqual0(BigDecimal value) {
        if (value == null) {
            value = new BigDecimal("0");
        }

        return value.compareTo(new BigDecimal("0")) == 0;
    }

    public static boolean isLess0(String value) {
        return compareTo(value, "0") < 0;
    }

    public static boolean isLess0(BigDecimal value) {
        return value.compareTo(new BigDecimal("0")) < 0;
    }

    public static String getGreater(String value1, String value2) {
        return compareTo(value1, value2) > 0 ? value1 : value2;
    }

    public static String getLess(String value1, String value2) {
        return compareTo(value1, value2) < 0 ? value1 : value2;
    }

    public static String getLess(String value1, BigDecimal value2) {
        return compareTo(value1, value2) < 0 ? value1 : value2.stripTrailingZeros().toPlainString();
    }
}
