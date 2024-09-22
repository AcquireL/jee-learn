package com.briup.jee.address;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GetLocalMacAddress {

    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
            byte[] macAddress = networkInterface.getHardwareAddress();

            StringBuilder macAddressString = new StringBuilder();
            for (int i = 0; i < macAddress.length; i++) {
                macAddressString.append(String.format("%02X%s", macAddress[i], (i < macAddress.length - 1) ? "-" : ""));
            }
            System.out.println("Local MAC Address: " + macAddressString.toString());
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }
}
