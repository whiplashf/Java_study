package com.gxf.udp;

/*
    Author: Whiplash
    Date: 2021/12/30 17:10
*/

import java.io.IOException;
import java.net.*;

public class UDPsender01{
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        // 发送信息
        String s1 = "hello~吃火锅~";
        byte buf[] = s1.getBytes();
        int len = buf.length;
        DatagramPacket datagramPacket = new DatagramPacket(buf, len, InetAddress.getByName("10.249.47.107"), 8888);
        socket.send(datagramPacket);
        System.out.println("我: " + s1);

        // 接收信息
        byte[] buf2 = new byte[1024];
        DatagramPacket datagramPacket2 = new DatagramPacket(buf2, buf2.length);
        System.out.println("对方正在输入...");
        socket.receive(datagramPacket2);
        int len2 = datagramPacket2.getLength();
        byte data[] = datagramPacket2.getData();
        String s = new String(data, 0, len2);
        System.out.println("nini: " + s);

        socket.close();
        System.out.println("end.");
    }
}
