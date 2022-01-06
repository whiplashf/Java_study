package com.gxf.upload;

/*
    Author: Whiplash
    Date: 2021/12/30 15:12
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpFileUploadServer {
    public static void main(String[] args) throws IOException {
        String recvPath = "src\\temp.jpg";
        // 额外开一个文件输出流，用于接收图片并保存到文件中
        FileOutputStream fileOutputStream = new FileOutputStream(recvPath);

        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
//        InputStream inputStream = socket.getInputStream();
        System.out.println("监听中...");

        byte buf[] = new byte[1024];
        int len = 0;
        while ((len=socket.getInputStream().read(buf))!=-1){
            fileOutputStream.write(buf, 0 ,len);
        }
        fileOutputStream.close();

        System.out.println("接收到客户端发送的图片");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到图片".getBytes());
        socket.shutdownOutput();


        outputStream.close();
//        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

