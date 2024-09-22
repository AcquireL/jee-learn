package com.briup.jee.address;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetMacAddressExample {

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("172.18.77.20"); // 客户端 IP 地址

            // 获取客户端的网络接口
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            if (network == null) {
                System.out.println("无法获取客户端的网络接口");
                return;
            }

            byte[] mac = network.getHardwareAddress();

            if (mac == null) {
                System.out.println("无法获取 MAC 地址");
                return;
            }

            System.out.print("客户端 MAC 地址 : ");

            // 将 MAC 地址转换为可读形式
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());

        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }
}
