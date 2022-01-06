package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 17:00
    有个问题，不能连续操作。可能这是字符流的特性？因为字符流写完必须socketshutdown来表示结束，就把socket给断开了？
*/

import com.gxf.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HW03_server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1001);

        // 接收客户端输入
        Socket socket = serverSocket.accept(); // 建立链接
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        // 默认歌曲
        FileInputStream fileInputStream = new FileInputStream("src\\无名.mp3");

        OutputStream outputStream = socket.getOutputStream();

        String line;
        while (true) {
            line = br.readLine();
            if (line.equals("over")) {
                break;

            } else if (line.equals("高山流水")) {
                // 读文件
                System.out.printf("高山流水.mp3 传输中...");
                fileInputStream = new FileInputStream("src\\高山流水.mp3");

            } else if (line.equals("老子明天不上班")) {
                System.out.printf("老子明天不上班-谢帝.mp3 传输中...");
                fileInputStream = new FileInputStream("src\\老子明天不上班-谢帝.mp3");

            } else {
                System.out.printf("默认歌曲.mp3 传输中...");
            }
            // 发送音乐
            byte[] musicData = StreamUtils.streamToByteArray(fileInputStream);
            outputStream.write(musicData);
//            outputStream.close();
//            socket.shutdownOutput();
        }
//        socket.shutdownOutput();
        fileInputStream.close();
        br.close();
        socket.close();
        serverSocket.close();
    }
}
