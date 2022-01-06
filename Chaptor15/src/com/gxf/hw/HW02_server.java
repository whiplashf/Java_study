package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 16:20
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HW02_server {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket);

        int len = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();

        // 发送
        String content = new String(data, 0, len);
        System.out.println(content);
        byte[] answer = null;
        if(content.equals("四大名著")){
            answer = "四大名著是：《红楼梦》...".getBytes();
        } else {
            answer = "俺不懂".getBytes();
        }

        datagramPacket = new DatagramPacket(answer, answer.length,InetAddress.getByName("10.249.47.107"), 9999);
        socket.send(datagramPacket);
        socket.close();
    }
}
