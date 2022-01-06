package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/2 15:36
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HW01_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(789);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        // 发送
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        String line = null;
        String outPut = null;
        while ((line = br.readLine()) != null){
            if (line.equals("over")){
                outPut = "服务器退出...";
                break;
            } else if(line.equals("hobby")){
                outPut = "学习java编程";
            } else if(line.equals("name")) {
                outPut = "我是nova";
            } else {
                outPut = "说啥呢？";
            }
            bw.write(outPut);
            bw.newLine();
            bw.flush();
        }

        br.close();
        socket.close();
        serverSocket.close();
    }
}
