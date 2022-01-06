package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 16:22
*/

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class HW02_client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999); // 监听这个端口
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入问题：");
        byte[] question = scanner.next().getBytes();
        DatagramPacket datagramPacket= new DatagramPacket(question, question.length, InetAddress.getByName("10.249.47.107"), 8888);
        socket.send(datagramPacket);

        byte[] buf = new byte[1024];
        datagramPacket = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket); // 停在这里
        int len = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, len));
        socket.close();

    }
}
