package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 17:20
*/

import com.gxf.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class HW03_client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("10.249.47.107"), 1001);

        // 输出指令
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        // 存储返回的音乐
        String filePath = "s:\\music0.mp3";

        InputStream inputStream = socket.getInputStream();

        Scanner scanner = new Scanner(System.in);
        String line = null;
        while (true) {
            // 发送指令
            System.out.print("请输入音乐名称：");
            line = scanner.next();

            bw.write(line);
            bw.newLine();
            bw.flush();

            if (line.equals("over")) break;

            // 接收返回来的音乐
            byte[] data_temp = StreamUtils.streamToByteArray(inputStream);
            byte[] data = Arrays.copyOf(data_temp, data_temp.length - 6); // 去掉两个-1结束标志位

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write(data);
            fileOutputStream.close();

            System.out.println(line + " 已下载到" + filePath);
        }

        System.out.println("客户端退出...");
        inputStream.close();
        bw.close();
        socket.close();
    }
}
