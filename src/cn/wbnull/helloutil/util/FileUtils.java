package cn.wbnull.helloutil.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * File 工具类
 *
 * @author dukunbiao(null) 2018-08-08
 * https://github.com/dkbnull/HelloUtil
 */
public class FileUtils {

    public static final int FILE_TAG_WRITE = 0;
    public static final int FILE_TAG_APPEND = 1;
    public static final int FILE_TAG_APPEND_NEW_LINE = 2;

    private FileUtils() {
    }

    /**
     * 写文件
     *
     * @param path    路径
     * @param value   内容
     * @param charset 字符集
     * @param tag     保存方式 0:保存为新文件;1:追加保存;2:另起一行追加保存
     * @throws Exception
     */
    public static void writeFile(String path, String value, String charset, int tag) throws Exception {
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            File file = new File(path);

            if (FILE_TAG_WRITE == tag) {
                if (file.exists()) {
                    file.delete();
                }

                outputStream = new FileOutputStream(file);
            } else if (FILE_TAG_APPEND == tag) {
                outputStream = new FileOutputStream(file, true);
            } else {
                outputStream = new FileOutputStream(file, true);
                outputStream.write("\r\n".getBytes());
            }
            outputStreamWriter = new OutputStreamWriter(outputStream, charset);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(value);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读文件
     *
     * @param path    路径
     * @param charset 字符集
     * @return 文件内容List
     * @throws Exception
     */
    public static List<String> readFile(String path, String charset) throws Exception {
        File file = new File(path);

        if (!file.exists()) {
            throw new Exception("file not exist:" + path);
        }

        try (InputStream inputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            List<String> listValue = new ArrayList<>();

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                listValue.add(str);
            }

            return listValue;
        }
    }

    /**
     * 获取指定路径文件名列表
     *
     * @param path 路径
     * @return 文件名列表
     */
    public static List<String> getFilesName(String path) {
        List<String> filesList = new ArrayList<>();

        File[] files = new File(path).listFiles();

        if (files == null) {
            return filesList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                getFilesName(file.getPath(), filesList);
            } else {
                filesList.add(file.getName());
            }
        }

        return filesList;
    }

    private static List<String> getFilesName(String path, List<String> filesList) {
        File[] files = new File(path).listFiles();

        if (files == null) {
            return filesList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                getFilesName(file.getPath(), filesList);
            } else {
                filesList.add(file.getName());
            }
        }

        return filesList;
    }

    /**
     * 获取指定路径文件路径列表
     *
     * @param path 路径
     * @return 文件路径列表
     */
    public static List<String> getFilesPath(String path) throws Exception {
        List<String> filesList = new ArrayList<>();

        File[] files = new File(path).listFiles();

        if (files == null) {
            return filesList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                getFilesPath(file.getPath(), filesList);
            } else {
                filesList.add(file.getCanonicalPath());
            }
        }

        return filesList;
    }

    private static List<String> getFilesPath(String path, List<String> filesList) throws Exception {
        File[] files = new File(path).listFiles();

        if (files == null) {
            return filesList;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                getFilesPath(file.getPath(), filesList);
            } else {
                filesList.add(file.getCanonicalPath());
            }
        }

        return filesList;
    }

    /**
     * 获取指定路径文件列表
     *
     * @param path 路径
     * @return 文件列表
     */
    public static List<File> getFiles(String path) {
        List<File> filesList = new ArrayList<>();
        getFiles(path, filesList);

        return filesList;
    }

    private static void getFiles(String path, List<File> filesList) {
        File[] files = new File(path).listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                getFiles(file.getPath(), filesList);
            } else {
                filesList.add(file);
            }
        }
    }

    public static List<File> getRootFiles(String path) {
        List<File> filesList = new ArrayList<>();
        getRootFiles(path, filesList);

        return filesList;
    }

    private static void getRootFiles(String path, List<File> filesList) {
        File[] files = new File(path).listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                continue;
            }

            filesList.add(file);
        }
    }

    public static JSONObject getFilesWithPath(String path) throws Exception {
        JSONObject filesPath = new JSONObject();
        getFilesWithPath(path, filesPath);

        return filesPath;
    }

    private static void getFilesWithPath(String path, JSONObject filesPath) throws Exception {
        File[] files = new File(path).listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                JSONObject filePath;
                if (filesPath.containsKey(file.getName())) {
                    filePath = filesPath.getJSONObject(file.getName());
                } else {
                    filePath = new JSONObject();
                }

                getFilesWithPath(file.getPath(), filePath);
                filesPath.put(file.getName(), filePath);
            } else {
                filesPath.put(file.getName(), file.getCanonicalPath());
            }
        }
    }

    public static String formatFileSize(long length) {
        DecimalFormat df = new DecimalFormat("#.00");

        if (length < 1024) {
            return df.format((double) length) + "B";
        }
        if (length < 1048576) {
            return df.format((double) length / 1024) + "K";
        }
        if (length < 1073741824) {
            return df.format((double) length / 1048576) + "M";
        }

        return df.format((double) length / 1073741824) + "G";
    }
}
