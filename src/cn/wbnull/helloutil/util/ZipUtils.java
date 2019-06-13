package cn.wbnull.helloutil.util;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Zip 工具类
 *
 * @author dukunbiao(null)  2019-04-18
 *         https://github.com/dkbnull/Util
 */
public class ZipUtils {

    private static final int BUFFER_SIZE = 2048;

    private ZipUtils() {
    }

    /**
     * 压缩文件
     *
     * @param pathname    待压缩文件路径
     * @param zipPathname 压缩后文件存放路径
     * @return
     * @throws Exception
     */
    public static boolean zipFiles(String pathname, String zipPathname) throws Exception {
        return zipFiles(pathname, zipPathname, true);
    }

    /**
     * 压缩文件
     *
     * @param pathname      待压缩文件路径
     * @param zipPathname   压缩后文件存放路径
     * @param keepDirectory 是否保留原有目录结构
     * @return
     * @throws Exception
     */
    public static boolean zipFiles(String pathname, String zipPathname, boolean keepDirectory) throws Exception {
        File file = new File(pathname);
        if (!file.exists()) {
            return false;
        }

        File zipFile = new File(zipPathname);
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }

        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(zipPathname);
            outputStream = new BufferedOutputStream(fileOutputStream);
            zipOutputStream = new ZipOutputStream(outputStream);

            zipFiles(file, zipOutputStream, file.getName(), keepDirectory);
            zipOutputStream.flush();

            return true;
        } finally {
            close(null, null, fileOutputStream, outputStream, zipOutputStream);
        }
    }

    /**
     * 压缩文件
     *
     * @param files       待压缩文件列表
     * @param zipPathname 压缩后文件存放路径
     * @return
     * @throws Exception
     */
    public static boolean zipFiles(List<File> files, String zipPathname) throws Exception {
        if (ListUtils.isEmpty(files)) {
            return false;
        }

        File zipFile = new File(zipPathname);
        if (!zipFile.getParentFile().exists()) {
            zipFile.getParentFile().mkdirs();
        }

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(zipPathname);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            zipOutputStream = new ZipOutputStream(bufferedOutputStream);

            for (File file : files) {
                zipFiles(file, zipOutputStream, file.getName(), false);
            }

            zipOutputStream.flush();

            return true;
        } finally {
            close(null, null, fileOutputStream, bufferedOutputStream, zipOutputStream);
        }
    }

    private static void zipFiles(File file, ZipOutputStream zipOutputStream, String filename, boolean keepDirectory) throws Exception {
        if (file.isFile()) {
            byte[] buf = new byte[BUFFER_SIZE];

            FileInputStream fileInputStream = null;
            InputStream inputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
                inputStream = new BufferedInputStream(fileInputStream);

                zipOutputStream.putNextEntry(new ZipEntry(filename));
                int length;
                while ((length = inputStream.read(buf)) != -1) {
                    zipOutputStream.write(buf, 0, length);
                }
                zipOutputStream.closeEntry();
            } finally {
                close(fileInputStream, inputStream, null, null, null);
            }
        } else {
            File[] files = file.listFiles();

            if (files == null || files.length == 0) {
                if (keepDirectory) {
                    zipOutputStream.putNextEntry(new ZipEntry(filename + File.separator));
                    zipOutputStream.closeEntry();
                }
            } else {
                for (File childFile : files) {
                    if (keepDirectory) {
                        zipFiles(childFile, zipOutputStream, filename + File.separator + childFile.getName(), true);
                    } else {
                        zipFiles(childFile, zipOutputStream, childFile.getName(), false);
                    }
                }
            }
        }
    }

    private static void close(FileInputStream fis, InputStream is, FileOutputStream fos, OutputStream os, ZipOutputStream zos) {
        try {
            if (is != null) {
                is.close();
            }
            if (fis != null) {
                fis.close();
            }

            if (zos != null) {
                zos.closeEntry();
                zos.close();
            }
            if (os != null) {
                os.close();
            }
            if (fos != null) {
                fos.close();
            }
        } catch (IOException e) {
        }
    }
}
