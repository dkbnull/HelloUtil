# Hello Util	通用工具类	v1.0.15

GitHub	[https://github.com/dkbnull/HelloUtil](https://github.com/dkbnull/HelloUtil)

## 开发环境

* JDK：1.8

##  StringUtils	String 工具类

### 方法摘要

| 返回值  | 摘要                                                         |
| ------- | ------------------------------------------------------------ |
| boolean | isEmpty(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查指定字符串是否为空 |
| boolean | areNotEmpty(String... values)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查指定字符串列表是否不为空 |
| boolean | isNumeric(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查String是否为数值型字符串，包含整数、小数 |
| boolean | isInteger(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查String是否是int型字符串 |
| String  | substringValue(String value, int beginIndex, int endIndex)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按要求截取指定长度字符串 |
| String  | substringValue(String value, int length, String tag)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按要求截取指定长度字符串，不足则返回完整字符串 |
| String  | random(int length)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定长度随机字符串 |
| String  | randomNonce(int length)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定长度随机字符串（数字、字母） |
| int     | toInt(String value, int defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String转int，格式不正确则返回默认值 |
| long    | toLong(String value, long defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String转long，格式不正确则返回默认值 |
| double  | toDouble(String value, double defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String转double，格式不正确则返回默认值 |
| String  | toHex(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取16进制字符串 |
| String  | byteToHex(byte[] data)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取16进制字符串 |
| String  | hexToString(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16进制字符串转String |
| byte[]  | hexToByte(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;16进制字符串转byte |
| String  | toCharsetString(String value, String fromCharset, String toCharset)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定编码格式字符串 |
| String  | toUTF8String(String value, String fromCharset)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取UTF-8编码格式字符串 |
| String  | toUTF8String(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取UTF-8编码格式字符串 |
| String  | stringPadding(String value, int length, String tag, String charset)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;字符串补空格，字符串长度大于补全后长度则截取字符串 |
| String  | stringPadding(String value, int length, String fill, String tag, String charset)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;字符串补全，字符串长度大于补全后长度则截取字符串 |
| String  | changeF2Y(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分转元 |
| String  | changeY2F(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;元转分 |
| String  | changeG2Kg(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;克转千克 |
| String  | changeKg2G(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;千克转克 |

### 方法详细信息

#### isEmpty

```java
boolean isEmpty(String value)
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
```

---

#### areNotEmpty

```java
boolean areNotEmpty(String... values)
                            /**
                             * 检查指定字符串列表是否不为空
                             *
                             * @param values 待检查字符串列表
                             * @return true/false
                             */
```

---

#### isNumeric

```java
boolean isNumeric(String value)
                            /**
                             * 检查String是否为数值型字符串，包含整数、小数
                             *
                             * @param value 待检查字符串
                             * @return true/false
                             */
```

---

#### isInteger

```java
boolean isInteger(String value)
                            /**
                             * 检查String是否是int型字符串
                             *
                             * @param value 待检查字符串
                             * @return true/false
                             */
```

---

#### substringValue

```java
String substringValue(String value, int beginIndex, int endIndex)
                            /**
                             * 按要求截取指定长度字符串
                             *
                             * @param value      待截取字符串
                             * @param beginIndex 起始位置
                             * @param endIndex   结束位置
                             * @return 截取后字符串
                             */
```

---

#### substringValue

```java
String substringValue(String value, int length, String tag)
                            /**
                             * 按要求截取指定长度字符串，不足则返回完整字符串
                             *
                             * @param value  待截取字符串
                             * @param length 截取长度
                             * @param tag    R 右截取   L 左截取
                             * @return 截取后字符串
                             */
```

---

#### random

```java
String random(int length)
                            /**
                             * 获取指定长度随机字符串
                             *
                             * @param length 随机字符串长度
                             * @return 随机字符串
                             */
```

---

#### randomNonce

~~~java
String randomNonce(int length)
                            /**
                             * 获取指定长度随机字符串（数字、字母）
                             *
                             * @param length 随机字符串长度
                             * @return
                             */
~~~

---

#### toInt

```java
int toInt(String value, int defaultValue)
                            /**
                             * String转int，格式不正确则返回默认值
                             *
                             * @param value        字符串
                             * @param defaultValue 默认值
                             * @return 数值
                             */
```

---

#### toLong

```java
long toLong(String value, long defaultValue)
                            /**
                             * String转long，格式不正确则返回默认值
                             *
                             * @param value        字符串
                             * @param defaultValue 默认值
                             * @return 数值
                             */
```

---

#### toDouble

```java
double toDouble(String value, double defaultValue)
                            /**
                             * String转double，格式不正确则返回默认值
                             *
                             * @param value        字符串
                             * @param defaultValue 默认值
                             * @return 数值
                             */
```

---

#### toHex

```java
String toHex(String value)
                            /**
                             * 获取16进制字符串
                             *
                             * @param value 待转化数据
                             * @return 16进制字符串
                             */
```

---

#### byteToHex

```java
String byteToHex(byte[] data)
                            /**
                             * 获取16进制字符串
                             *
                             * @param data 待转化数据
                             * @return 16进制字符串
                             */
```

---

#### hexToString

```java
String hexToString(String value)
                            /**
                             * 16进制字符串转String
                             *
                             * @param value 16进制字符串
                             * @return 转换后字符串
                             */
```

---

#### hexToByte

```java
byte[] hexToByte(String value)
                            /**
                             * 16进制字符串转byte
                             *
                             * @param value 16进制字符串
                             * @return byte
                             */
```

---

#### toCharsetString

```java
String toCharsetString(String value, String fromCharset, String toCharset) throws Exception
                            /**
                             * 获取指定编码格式字符串
                             *
                             * @param value       待转化字符串
                             * @param fromCharset 待转化字符串字符集
                             * @param toCharset   转化后字符串字符集
                             * @return 转换后字符串
                             * @throws Exception
                             */
```

---

#### toUTF8String

```java
String toUTF8String(String value, String fromCharset) throws Exception
                            /**
                             * 获取UTF-8编码格式字符串
                             *
                             * @param value       待转化字符串
                             * @param fromCharset 待转化字符串字符集
                             * @return 转换后字符串
                             * @throws Exception
                             */
```

---

#### toUTF8String

```java
String toUTF8String(String value) throws Exception
                            /**
                             * 获取UTF-8编码格式字符串
                             *
                             * @param value 待转化字符串
                             * @return UTF-8编码格式字符串
                             * @throws Exception
                             */
```

---

#### stringPadding

```java
String stringPadding(String value, int length, String tag, String charset)
                            /**
                             * 字符串补空格，字符串长度大于补全后长度则截取字符串
                             *
                             * @param value   待补全字符串
                             * @param length  补全后长度
                             * @param tag     R 右补全   L 左补全
                             * @param charset 字符集
                             * @return 补全后字符串
                             */
```

---

#### stringPadding

```java
String stringPadding(String value, int length, String fill, String tag, String charset)
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
```

---

#### changeF2Y

~~~java
String changeF2Y(String value)
                            /**
                             * 分转元
                             *
                             * @param value 金额，分
                             * @return 金额，元
                             */
~~~

---

#### changeY2F

~~~java
String changeY2F(String value)
                            /**
                             * 元转分
                             *
                             * @param value 金额，元
                             * @return 金额，分
                             */
~~~

---

#### changeG2Kg

~~~java
String changeG2Kg(String value)
                            /**
                             * 克转千克
                             *
                             * @param value 重量，克
                             * @return 重量，千克
                             */
~~~

---

#### changeKg2G

~~~java
String changeKg2G(String value)
                            /**
                             * 千克转克
                             *
                             * @param value 重量，千克
                             * @return 重量，克
                             */
~~~

---



## BigDecimalUtils	BigDecimal工具类

### 方法摘要

| 返回值 | 摘要                                                         |
| ------ | ------------------------------------------------------------ |
| int    | add(int value1, int value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加 |
| double | add(double value1, double value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加 |
| String | add(String value1, String value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加 |
| int    | subtract(int value1, int value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;减 |
| double | subtract(double value1, double value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;减 |
| String | subtract(String value1, String value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;减 |
| int    | multiply(int value1, int value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘 |
| double | multiply(double value1, double value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘 |
| String | multiply(String value1, String value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘 |
| double | multiply(double value1, double value2, int scale, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘 |
| String | multiply(String value1, String value2, int scale, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乘 |
| double | divide(int value1, int value2, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| double | divide(double value1, double value2, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| String | divide(String value1, String value2, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| double | divide(int value1, int value2, int scale, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| double | divide(double value1, double value2, int scale, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| String | divide(String value1, String value2, int scale, int roundingMode)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;除 |
| double | format(double value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数值格式化 |
| String | format(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数值格式化 |
| int    | compareTo(double value1, double value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;比较大小 |
| int    | compareTo(String value1, String value2)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;比较大小 |

### 方法详细信息

#### add

```java
int add(int value1, int value2)
                            /**
                             * 加
                             *
                             * @param value1 加数
                             * @param value2 加数
                             * @return 和
                             */
```

---

#### add

~~~java
double add(double value1, double value2)
                            /**
                             * 加
                             *
                             * @param value1 加数
                             * @param value2 加数
                             * @return 和
                             */
~~~

---

#### add

~~~java
String add(String value1, String value2)
                            /**
                             * 加
                             *
                             * @param value1 加数
                             * @param value2 加数
                             * @return 和
                             */
~~~

---

#### subtract

~~~java
int subtract(int value1, int value2)
                            /**
                             * 减
                             *
                             * @param value1 被减数
                             * @param value2 减数
                             * @return 差
                             */
~~~

---

#### subtract

~~~java
double subtract(double value1, double value2)
                            /**
                             * 减
                             *
                             * @param value1 被减数
                             * @param value2 减数
                             * @return 差
                             */
~~~

---

#### subtract

~~~java
String subtract(String value1, String value2)
                            /**
                             * 减
                             *
                             * @param value1 被减数
                             * @param value2 减数
                             * @return 差
                             */
~~~

---

#### multiply

~~~java
int multiply(int value1, int value2)
                            /**
                             * 乘
                             *
                             * @param value1 乘数
                             * @param value2 乘数
                             * @return 积
                             */
~~~

---

#### multiply

~~~java
double multiply(double value1, double value2)
                            /**
                             * 乘
                             *
                             * @param value1 乘数
                             * @param value2 乘数
                             * @return 积
                             */
~~~

---

#### multiply

~~~java
String multiply(String value1, String value2)
                            /**
                             * 乘
                             *
                             * @param value1 乘数
                             * @param value2 乘数
                             * @return 积
                             */
~~~

---

#### multiply

~~~java
double multiply(double value1, double value2, int scale, int roundingMode)
                            /**
                             * 乘
                             *
                             * @param value1       乘数
                             * @param value2       乘数
                             * @param scale        精度
                             * @param roundingMode 舍入模式
                             * @return 积
                             */
~~~

---

#### multiply

~~~java
String multiply(String value1, String value2, int scale, int roundingMode)
                            /**
                             * 乘
                             *
                             * @param value1       乘数
                             * @param value2       乘数
                             * @param scale        精度
                             * @param roundingMode 舍入模式
                             * @return 积
                             */
~~~

---

#### divide

~~~java
double divide(int value1, int value2, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### divide

~~~java
double divide(double value1, double value2, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### divide

~~~java
String divide(String value1, String value2, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### divide

~~~java
double divide(int value1, int value2, int scale, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param scale        精度
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### divide

~~~java
double divide(double value1, double value2, int scale, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param scale        精度
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### divide

~~~java
String divide(String value1, String value2, int scale, int roundingMode)
                            /**
                             * 除
                             *
                             * @param value1       被除数
                             * @param value2       除数
                             * @param scale        精度
                             * @param roundingMode 舍入模式
                             * @return 商
                             */
~~~

---

#### format

~~~java
double format(double value)
                            /**
                             * 数值格式化
                             *
                             * @param value 待格式化数值
                             * @return 格式化后数值
                             */
~~~

---

#### format

~~~java
String format(String value)
                            /**
                             * 数值格式化
                             *
                             * @param value 待格式化数值
                             * @return 格式化后数值
                             */
~~~

---

#### compareTo

~~~java
int compareTo(double value1, double value2)
                            /**
                             * 比较大小
                             *
                             * @param value1
                             * @param value2
                             * @return -1:<, 0:=, 1:>
                             */
~~~

---

#### compareTo

~~~java
int compareTo(String value1, String value2)
                            /**
                             * 比较大小
                             *
                             * @param value1
                             * @param value2
                             * @return -1:<, 0:=, 1:>
                             */
~~~

---

## ListUtils	List 工具类

### 方法摘要

| 返回值  | 摘要                                                         |
| ------- | ------------------------------------------------------------ |
| boolean | isEmpty(List list)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查List是否为空 |

### 方法详细信息

#### isEmpty

```java
boolean isEmpty(List list)
                            /**
                             * 检查List是否为空
                             *
                             * @param list 待检查List
                             * @return true/false
                             */
```

---

## MapUtils	Map 工具类

### 方法摘要

| 返回值              | 摘要                                                         |
| ------------------- | ------------------------------------------------------------ |
| boolean             | isEmpty(Map map)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查Map是否为空 |
| String              | getMapString(Map map, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String型获取Map value值 |
| int                 | getMapInt(Map map, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取Map value值 |
| int                 | getMapInt(Map map, String key, int defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取Map value值，无法转化则返回默认值 |
| double              | getMapDouble(Map map, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取Map value值 |
| double              | getMapDouble(Map map, String key, double defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取Map value值，无法转化则返回默认值 |
| Map<String, String> | javaBeanToMap(Object object)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java Bean 转Map |
| <T> T               | mapToJavaBean(Map map, Class<T> clazz)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Map转 Java Bean |

### 方法详细信息

#### isEmpty

```java
boolean isEmpty(Map map)
                            /**
                             * 检查Map是否为空
                             *
                             * @param map 待检查Map
                             * @return true/false
                             */
```

---

#### getMapString

```java
String getMapString(Map map, String key)
                            /**
                             * String型获取Map value值
                             *
                             * @param map Map
                             * @param key key值
                             * @return value值
                             */
```

---

#### getMapInt

```java
int getMapInt(Map map, String key)
                            /**
                             * int型获取Map value值
                             *
                             * @param map Map
                             * @param key key值
                             * @return value值
                             */
```

---

#### getMapInt

```java
int getMapInt(Map map, String key, int defaultValue)
                            /**
                             * int型获取Map value值，无法转化则返回默认值
                             *
                             * @param map          Map
                             * @param key          key值
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

#### getMapDouble

```java
double getMapDouble(Map map, String key)
                            /**
                             * double型获取Map value值
                             *
                             * @param map Map
                             * @param key key值
                             * @return value值
                             */
```

---

#### getMapDouble

```java
double getMapDouble(Map map, String key, double defaultValue)
                            /**
                             * double型获取Map value值，无法转化则返回默认值
                             *
                             * @param map          Map
                             * @param key          key值
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

#### javaBeanToMap

```java
Map<String, String> javaBeanToMap(Object object)
                            /**
                             * Java Bean 转Map
                             *
                             * @param object 待转化Java Bean
                             * @return Map
                             */
```

---

#### mapToJavaBean

~~~java
<T> T mapToJavaBean(Map map, Class<T> clazz)
                            /**
                             * Map转 Java Bean
                             *
                             * @param map Map
                             * @return Java Bean
                             */
~~~

---

## JSONUtils	JSON 工具类

### 方法摘要

| 返回值              | 摘要                                                         |
| ------------------- | ------------------------------------------------------------ |
| boolean             | isEmpty(JSONObject json)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查JSON是否为空 |
| boolean             | isEmpty(JSONArray jsonArray)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查JSONArray是否为空 |
| String              | getJSONString(JSONObject json, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String型获取JSON value值 |
| int                 | getJSONInt(JSONObject json, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取JSON value值 |
| int                 | getJSONInt(JSONObject json, String key, int defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取JSON value值，无法转化则返回默认值 |
| double              | getJSONDouble(JSONObject json, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取JSON value值 |
| double              | getJSONDouble(JSONObject json, String key, double defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取JSON value值，无法转化则返回默认值 |
| JSONObject          | javaBeanToJSON(Object object)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java Bean 转JSON |
| JSONArray           | javaBeanToJSONArray(Object object)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java Bean 转JSONArray |
| Map<String, String> | JSONToMap(JSONObject json)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSON 转 Map |
| String              | JSONFormat(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格式化JSON字符串，不校验JSON格式合法性 |

### 方法详细信息

#### isEmpty

```java
boolean isEmpty(JSONObject json)
                            /**
                             * 检查JSON是否为空
                             *
                             * @param json 待检查JSON
                             * @return true/false
                             */
```

---

#### isEmpty

~~~java
boolean isEmpty(JSONArray jsonArray)
                            /**
                             * 检查JSONArray是否为空
                             *
                             * @param jsonArray 待检查JSONArray
                             * @return true/false
                             */
~~~

---

#### getJSONString

```java
String getJSONString(JSONObject json, String key)
                            /**
                             * String型获取JSON value值
                             *
                             * @param json JSON
                             * @param key  key值
                             * @return value值
                             */
```

---

#### getJSONInt

```java
int getJSONInt(JSONObject json, String key)
                            /**
                             * int型获取JSON value值
                             *
                             * @param json JSON
                             * @param key  key值
                             * @return value值
                             */
```

---

#### getJSONInt

```java
int getJSONInt(JSONObject json, String key, int defaultValue)
                            /**
                             * int型获取JSON value值，无法转化则返回默认值
                             *
                             * @param json         JSON
                             * @param key          key值
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

#### getJSONDouble

```java
double getJSONDouble(JSONObject json, String key)
                            /**
                             * double型获取JSON value值
                             *
                             * @param json JSON
                             * @param key  key值
                             * @return value值
                             */
```

---

#### getJSONDouble

```java
double getJSONDouble(JSONObject json, String key, double defaultValue)
                            /**
                             * double型获取JSON value值，无法转化则返回默认值
                             *
                             * @param json         JSON
                             * @param key          key值
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

####  javaBeanToJSON

```java
JSONObject javaBeanToJSON(Object object)
                            /**
                             * Java Bean 转JSON
                             *
                             * @param object 待转化Java Bean
                             * @return JSONObject
                             */
```

---

#### javaBeanToJSONArray

~~~java
JSONArray javaBeanToJSONArray(Object object)
                            /**
                             * Java Bean 转JSONArray
                             *
                             * @param object 待转化Java Bean
                             * @return JSONArray
                             */
~~~

---

#### JSONToMap

```java
Map<String, String> JSONToMap(JSONObject json)
                            /**
                             * JSON 转 Map
                             *
                             * @param json 待转化JSON
                             * @return Map
                             */
```

---

#### JSONFormat

```java
String JSONFormat(String value)
                            /**
                             * 格式化JSON字符串，不校验JSON格式合法性
                             *
                             * @param value 待格式化JSON字符串
                             * @return 格式化后JSON字符串
                             */
```

---

## XmlUtils	XML 工具类

### 方法摘要

| 返回值     | 摘要                                                         |
| ---------- | ------------------------------------------------------------ |
| boolean    | isXml(String value)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检查String是否为XML格式 |
| String     | mapToXml(Map<String, Object> map, String root)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Map转XML，支持fastjson |
| String     | javaBeanToXml(Object object, String root)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java Bean转XML |
| String     | mapsToXml(List<Map<String, Object>> maps, String root, String childRoot)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Map List转XML，支持fastjson |
| String     | jsonArrayToXml(JSONArray jsonArray, String root, String childRoot)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JSONArray转XML |
| JSONObject | xmlToJSON(String xml)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XML转JSON，支持Map<String, Object>接收 |
| <T> T      | xmlToJavaBean(String xml, Class<T> clazz)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XML转 Java Bean |
| String     | getXmlString(String xml, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;String型获取XML value值 |
| int        | getXmlInt(String xml, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取XML value值 |
| int        | getXmlInt(String xml, String key, int defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int型获取XML value值，无法转化则返回默认值 |
| double     | getXmlDouble(String xml, String key)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取XML value值 |
| double     | getXmlDouble(String xml, String key, double defaultValue)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;double型获取XML value值，无法转化则返回默认值 |

### 方法详细信息

#### isXml

```java
boolean isXml(String value)
                            /**
                             * 检查String是否为XML格式
                             *
                             * @param value 待检查字符串
                             * @return true/false
                             */
```

---

#### mapToXml

```java
String mapToXml(Map<String, Object> map, String root)
                            /**
                             * Map转XML，支持fastjson
                             *
                             * @param map  待转化Map
                             * @param root 根节点
                             * @return XML格式字符串
                             */
```

---

#### javaBeanToXml

```java
String javaBeanToXml(Object object, String root)
                            /**
                             * Java Bean转XML
                             *
                             * @param object 待转化Java Bean
                             * @param root   根节点
                             * @return XML格式字符串
                             */
```

---

#### mapsToXml

```java
String mapsToXml(List<Map<String, Object>> maps, String root, String childRoot)
                            /**
                             * Map List转XML，支持fastjson
                             *
                             * @param maps      待转化Map List
                             * @param root      根节点
                             * @param childRoot 子节点
                             * @return XML格式字符串
                             */
```

---

####  jsonArrayToXml

```java
String jsonArrayToXml(JSONArray jsonArray, String root, String childRoot)
                            /**
                             * JSONArray转XML
                             *
                             * @param jsonArray 待转化JSONArray
                             * @param root      根节点
                             * @param childRoot 子节点
                             * @return XML格式字符串
                             */
```

---

#### xmlToJSON

```java
JSONObject xmlToJSON(String xml) throws Exception
                            /**
                             * XML转JSON，支持Map<String, Object>接收
                             *
                             * @param xml 待转化XML
                             * @return JSON
                             * @throws Exception
                             */
```

---

####  xmlToJavaBean

~~~java
<T> T xmlToJavaBean(String xml, Class<T> clazz) throws Exception
                            /**
                             * XML转 Java Bean
                             *
                             * @param xml   待转化XML
                             * @param clazz 返回参数类型
                             * @param <T>
                             * @return
                             * @throws Exception
                             */
~~~

---

#### getXmlString

```java
String getXmlString(String xml, String key) throws Exception
                            /**
                             * String型获取XML value值
                             *
                             * @param xml XML
                             * @param key XML节点
                             * @return value值
                             * @throws Exception
                             */
```

---

#### getXmlInt

```java
int getXmlInt(String xml, String key) throws Exception
                            /**
                             * int型获取XML value值
                             *
                             * @param xml XML
                             * @param key XML节点
                             * @return value值
                             * @throws Exception
                             */
```

---

#### getXmlInt

```java
int getXmlInt(String xml, String key, int defaultValue)
                            /**
                             * int型获取XML value值，无法转化则返回默认值
                             *
                             * @param xml          XML
                             * @param key          XML节点
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

#### getXmlDouble

```java
double getXmlDouble(String xml, String key) throws Exception
                            /**
                             * double型获取XML value值
                             *
                             * @param xml XML
                             * @param key XML节点
                             * @return value值
                             * @throws Exception
                             */
```

---

#### getXmlDouble

```java
double getXmlDouble(String xml, String key, double defaultValue)
                            /**
                             * double型获取XML value值，无法转化则返回默认值
                             *
                             * @param xml          XML
                             * @param key          XML节点
                             * @param defaultValue 默认值
                             * @return value值
                             */
```

---

## DateUtils	Date 工具类

### 方法摘要

| 返回值 | 摘要                                                         |
| ------ | ------------------------------------------------------------ |
| String | dateFormat()<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间格式化 |
| String | dateFormat(Date date)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间格式化 |
| String | dateFormat(String format)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间格式化 |
| String | dateFormat(Date date, String format)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间格式化 |
| String | dateFormat(String dateValue, String toFormat)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间字符串格式化 |
| String | dateFormat(String dateValue, String fromFormat, String toFormat)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间字符串格式化 |
| String | currentTime()<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取Linux时间戳，精确到秒 |

### 方法详细信息

#### dateFormat

~~~java
String dateFormat()
                            /**
                             * 时间格式化
                             *
                             * @return 时间字符串
                             */
~~~

---

#### dateFormat

```java
String dateFormat(Date date)
                            /**
                             * 时间格式化
                             *
                             * @param date 待格式化时间
                             * @return 时间字符串
                             */
```

---

#### dateFormat

~~~java
String dateFormat(String format)
                            /**
                             * 时间格式化
                             *
                             * @param format 格式
                             * @return 时间字符串
                             */
~~~

---

#### dateFormat

```java
String dateFormat(Date date, String format)
                            /**
                             * 时间格式化
                             *
                             * @param date   待格式化时间
                             * @param format 格式
                             * @return 时间字符串
                             */
```

---

#### dateFormat

```java
String dateFormat(String dateValue, String toFormat) throws Exception
                            /**
                             * 时间字符串格式化
                             *
                             * @param dateValue 待格式化时间字符串
                             * @param toFormat  要格式化的格式
                             * @return 时间字符串
                             * @throws Exception
                             */
```

---

#### dateFormat

```java
String dateFormat(String dateValue, String fromFormat, String toFormat) throws Exception
                            /**
                             * 时间字符串格式化
                             *
                             * @param dateValue  待格式化时间字符串
                             * @param fromFormat 待格式化时间字符串格式
                             * @param toFormat   要格式化的格式
                             * @return 时间字符串
                             * @throws Exception
                             */
```

---

#### currentTime

```java
String currentTime()
                            /**
                             * 获取Linux时间戳，精确到秒
                             *
                             * @return Linux时间戳
                             */
```

---

## FileUtils	File 工具类

### 方法摘要

| 返回值       | 摘要                                                         |
| ------------ | ------------------------------------------------------------ |
| void         | writeFile(String path, String value, String charset, int tag)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;写文件 |
| List<String> | readFile(String path, String charset)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;读文件 |
| List<String> | getFilesName(String path)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定路径文件名列表 |
| List<String> | getFilesPath(String path)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定路径文件路径列表 |
| List<String> | getFiles(String path)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获取指定路径文件列表 |

### 方法详细信息

#### writeFile

```java
void writeFile(String path, String value, String charset, int tag) throws Exception
                            /**
                             * 写文件
                             *
                             * @param path    路径
                             * @param value   内容
                             * @param charset 字符集
                             * @param tag     保存方式 0:保存为新文件;1:追加保存;2:另起一行追加保存
                             * @throws Exception
                             */
```

---

#### readFile

```java
List<String> readFile(String path, String charset) throws Exception
                            /**
                             * 读文件
                             *
                             * @param path    路径
                             * @param charset 字符集
                             * @return 文件内容List
                             * @throws Exception
                             */
```

---

#### getFilesName

```java
List<String> getFilesName(String path)
                            /**
                             * 获取指定路径文件名列表
                             *
                             * @param path 路径
                             * @return 文件名列表
                             */
```

---

#### getFilesPath

~~~java
List<String> getFilesPath(String path) throws Exception
                            /**
                             * 获取指定路径文件路径列表
                             *
                             * @param path 路径
                             * @return 文件路径列表
                             */
~~~

---

#### getFiles

~~~java
List<File> getFiles(String path)
                            /**
                             * 获取指定路径文件列表
                             *
                             * @param path 路径
                             * @return 文件列表
                             */
~~~

---

## ZipUtils	Zip 工具类

### 方法摘要

| 返回值  | 摘要                                                         |
| ------- | ------------------------------------------------------------ |
| boolean | zipFiles(String pathname, String zipPathname)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压缩文件 |
| boolean | zipFiles(String pathname, String zipPathname, boolean keepDirectory)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压缩文件 |
| boolean | zipFiles(List<File> files, String zipPathname)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;压缩文件 |

### 方法详细信息

#### zipFiles

~~~java
boolean zipFiles(String pathname, String zipPathname) throws Exception
                            /**
                             * 压缩文件
                             *
                             * @param pathname    待压缩文件路径
                             * @param zipPathname 压缩后文件存放路径
                             * @return
                             * @throws Exception
                             */
~~~

---

#### zipFiles

~~~java
boolean zipFiles(String pathname, String zipPathname, boolean keepDirectory) throws Exception
                            /**
                             * 压缩文件
                             *
                             * @param pathname      待压缩文件路径
                             * @param zipPathname   压缩后文件存放路径
                             * @param keepDirectory 是否保留原有目录结构
                             * @return
                             * @throws Exception
                             */
~~~

---

#### zipFiles

~~~java
boolean zipFiles(List<File> files, String zipPathname) throws Exception
                            /**
                             * 压缩文件
                             *
                             * @param files       待压缩文件列表
                             * @param zipPathname 压缩后文件存放路径
                             * @return
                             * @throws Exception
                             */
~~~

---

## WebUtils	Web 工具类

### 方法摘要

| 返回值 | 摘要                                                         |
| ------ | ------------------------------------------------------------ |
| void   | initSSLSocketFactory(String keyPathname, String keyPassword, String trustPathname, String trustPassword)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;初始化SSL证书 |
| String | doPost(String url, Map<String, Object> params, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP POST请求 |
| String | doPost(String url, Map<String, Object> params, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP POST请求 |
| String | doPost(String url, String content, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP POST请求 |
| String | doPost(String url, String content, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP POST请求 |
| String | doPost(String url, String content, ContentType accept, ContentType contentType, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP POST请求 |
| String | doGet(String url, Map<String, Object> params, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP GET请求 |
| String | doGet(String url, Map<String, Object> params, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP GET请求 |
| String | doGet(String url, String content, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP GET请求 |
| String | doGet(String url, String content, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP GET请求 |
| String | doGet(String url, String content, ContentType accept, ContentType contentType, String charset, int connectTimeout, int readTimeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HTTP GET请求 |

### 方法详细信息

#### initSSLSocketFactory

~~~java
void initSSLSocketFactory(String keyPathname, String keyPassword, String trustPathname, String trustPassword) throws Exception
                            /**
                             * 初始化SSL证书
                             *
                             * @param keyPathname   客户端证书路径
                             * @param keyPassword   客户端证书密码
                             * @param trustPathname 信任证书路径
                             * @param trustPassword 信任证书密码
                             * @throws Exception
                             */
~~~

---

#### doPost

```java
String doPost(String url, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP POST请求
                             *
                             * @param url            请求地址
                             * @param params         请求参数
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doPost

```java
String doPost(String url, Map<String, Object> params, String charset, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP POST请求
                             *
                             * @param url            请求地址
                             * @param params         请求参数
                             * @param charset        字符集
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doPost

```java
String doPost(String url, String content, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP POST请求
                             *
                             * @param url            请求地址
                             * @param content        请求参数
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doPost

```java
String doPost(String url, String content, String charset, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP POST请求
                             *
                             * @param url            请求地址
                             * @param content        请求参数
                             * @param charset        字符集
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doPost

```java
String doPost(String url, String content, ContentType accept, ContentType contentType, String charset, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP POST请求
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
```

---

#### doGet

```java
String doGet(String url, Map<String, Object> params, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP GET请求
                             *
                             * @param url            请求地址
                             * @param params         请求参数
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doGet

```java
String doGet(String url, Map<String, Object> params, String charset, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP GET请求
                             *
                             * @param url            请求地址
                             * @param params         请求参数
                             * @param charset        字符集
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
```

---

#### doGet

~~~java
String doGet(String url, String content, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP GET请求
                             *
                             * @param url            请求地址
                             * @param content        请求参数
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
~~~

---

#### doGet

~~~java
String doGet(String url, String content, String charset, int connectTimeout, int readTimeout) throws Exception
                            /**
                             * HTTP GET请求
                             *
                             * @param url            请求地址
                             * @param content        请求参数
                             * @param charset        字符集
                             * @param connectTimeout 请求超时时间
                             * @param readTimeout    读取数据超时时间
                             * @return 返回参数
                             * @throws Exception
                             */
~~~

---

#### doGet

```java
String doGet(String url, String content, ContentType accept, ContentType contentType, String charset, int connectTimeout, int readTimeout) throws Exception
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
```

---

## ContentType	Content-Type

### 方法摘要

枚举HTTP请求常用 Content-Type

### 方法详细信息

```java
MULTIPART_FORM_DATA("multipart/form-data"),
APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
TEXT_PLAIN("text/plain"),
APPLICATION_JSON("application/json"),
APPLICATION_JAVASCRIPT("application/javascript"),
APPLICATION_XML("application/xml"),
TEXT_XML("text/xml"),
TEXT_JAVASCRIPT("text/javascript"),
TEXT_HTML("text/html");
```

---

## AxisUtils	Axis 工具类

### 方法摘要

| 返回值 | 摘要                                                         |
| ------ | ------------------------------------------------------------ |
| String | callWebService(String url, String namespace, String method, Map<String, Object> params, int timeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调用 WebService 服务 |
| String | callWebService(String url, String namespace, String method, String actionURI, Map<String, Object> params, int timeout)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调用 WebService 服务 |
| <T> T  | callWebService(String url, String namespace, String method, Map<String, Object> params, int timeout, Class<T> clazz)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调用 WebService 服务 |
| <T> T  | callWebServiceV2(String url, String namespace, String method, Map<String, Object> params, int timeout, Class<T> clazz)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调用 WebService 服务 |
| <T> T  | callWebService(String url, String namespace, String method, String actionURI, Map<String, Object> params, int timeout, Class<T> clazz)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;调用 WebService 服务 |

### 方法详细信息

#### callWebService

```java
String callWebService(String url, String namespace, String method, Map<String, Object> params, int timeout) throws Exception
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
```

---

#### callWebService

```java
String callWebService(String url, String namespace, String method, String actionURI, Map<String, Object> params, int timeout) throws Exception
                            /**
                             * 调用 WebService 服务
                             *
                             * @param url       请求地址
                             * @param namespace 命名空间
                             * @param method    接口方法
                             * @param actionURI SOAPActionURI
                             * @param params    请求参数
                             * @param timeout   超时时间
                             * @return
                             * @throws Exception
                             */
```

---

#### callWebService

```java
<T> T callWebService(String url, String namespace, String method, Map<String, Object> params, int timeout, Class<T> clazz) throws Exception
                            /**
                             * 调用 WebService 服务
                             *
                             * @param url       请求地址
                             * @param namespace 命名空间
                             * @param method    接口方法
                             * @param params    请求参数
                             * @param timeout   超时时间
                             * @param clazz     返回参数类型
                             * @param <T>
                             * @return
                             * @throws Exception
                             */
```

---

#### callWebServiceV2

~~~java
<T> T callWebServiceV2(String url, String namespace, String method, Map<String, Object> params, int timeout, Class<T> clazz) throws Exception
                            /**
                             * @param url       请求地址
                             * @param namespace 命名空间
                             * @param method    接口方法
                             * @param params    请求参数
                             * @param timeout   超时时间
                             * @param clazz     返回参数类型
                             * @param <T>
                             * @return
                             * @throws Exception
                             */
~~~

---

#### callWebService

```java
<T> T callWebService(String url, String namespace, String method, String actionURI, Map<String, Object> params, int timeout, Class<T> clazz) throws Exception
                            /**
                             * 调用 WebService 服务
                             *
                             * @param url       请求地址
                             * @param namespace 命名空间
                             * @param method    接口方法
                             * @param actionURI SOAPActionURI
                             * @param params    请求参数
                             * @param timeout   超时时间
                             * @param clazz     返回参数类型
                             * @param <T>
                             * @return
                             * @throws Exception
                             */
```

---

