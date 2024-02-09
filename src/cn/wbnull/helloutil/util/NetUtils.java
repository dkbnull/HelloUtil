package cn.wbnull.helloutil.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络工具类
 *
 * @author dukunbiao(null) 2021-08-24
 * https://github.com/dkbnull/HelloUtil
 */
public class NetUtils {

    private static final Pattern PATTERN_MAC = Pattern.compile("\\b\\w+:\\w+:\\w+:\\w+:\\w+:\\w+\\b");

    private NetUtils() {
    }

    public static String getLocalHost() throws Exception {
        return InetAddress.getLocalHost().toString();
    }

    public static String getLocalIp() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return getWinLocalIp();
        }

        return getLinuxLocalIp();
    }

    public static String getWinLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ignore) {

        }

        return "";
    }

    public static String getLinuxLocalIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces =
                    NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface;
            while (networkInterfaces.hasMoreElements()) {
                networkInterface = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses =
                        networkInterface.getInetAddresses();

                InetAddress inetAddress;
                while (inetAddresses.hasMoreElements()) {
                    inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ignore) {

        }

        return "";
    }

    public static String getLocalMac() throws Exception {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return getWinLocalMac();
        }

        return getLinuxLocalMac();
    }

    public static String getWinLocalMac() throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append(":");
            }
            //字节转换为整数
            int temp = mac[i] & 0xff;
            String str = Integer.toHexString(temp);
            if (str.length() == 1) {
                sb.append("0").append(str);
            } else {
                sb.append(str);
            }
        }

        return sb.toString();
    }

    public static String getLinuxLocalMac() {
        String mac = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ProcessBuilder("ifconfig").start()
                .getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = PATTERN_MAC.matcher(line);
                if (matcher.find()) {
                    mac = matcher.group(0);
                }
            }
        } catch (IOException ignore) {

        }

        return mac;
    }
}
