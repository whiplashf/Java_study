package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 15:46
*/

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HW01_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("10.249.47.107"), 789);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        Scanner scanner = new Scanner(System.in);
        String line = null;
        do {// 发送
            System.out.print("请输入指令：");
            line = scanner.next();
            bw.write(line);
            bw.newLine();
            bw.flush();

            // 接收返回来的信息
            String answer = br.readLine();
            System.out.println(answer);
        } while (!line.equals("over"));

        System.out.println("客户端退出...");
        bw.close();
        socket.close();
    }
}
