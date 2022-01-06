package com.gxf.udp;

/*
    Author: Whiplash
    Date: 2021/12/30 17:20
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPreceiver01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);

        // 接收信息
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        System.out.println("nini无聊中...");
        socket.receive(datagramPacket);
        int len = datagramPacket.getLength();
        byte data[] = datagramPacket.getData();
        String s = new String(data, 0, len);
        System.out.println("收到一条讯息:" + s);

        // 发动信息
        byte buf2[] = "不去了，有约了".getBytes();
        int len2 = buf2.length;
        DatagramPacket datagramPacket2 = new DatagramPacket(buf2, len2, InetAddress.getByName("10.249.47.107"), 9999);
        socket.send(datagramPacket2);

        socket.close();
        System.out.println("nini结束了会话。");

    }
}
