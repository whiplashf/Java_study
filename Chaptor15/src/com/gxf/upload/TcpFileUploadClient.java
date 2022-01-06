package com.gxf.upload;

/*
    Author: Whiplash
    Date: 2021/12/30 15:29
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpFileUploadClient {
    public static void main(String[] args) throws IOException {
        String srcPath = "F:\\图片素材\\Wallpaper\\lisa2.jpg";
        FileInputStream fileInputStream = new FileInputStream(srcPath);

        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        OutputStream outputStream = socket.getOutputStream();
        byte buf[] = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(buf))!=-1){ // 使用边读边写的方法
            outputStream.write(buf, 0, len);
        }
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte buf2[] = new byte[1024];
        int len2 = inputStream.read(buf2);
        if(new String(buf2, 0, len2).equals("收到图片")){
            System.out.println("发送成功，退出客户端");
        }else {
            System.out.println("发送失败");
        }

        inputStream.close();
        outputStream.close();
        socket.close();
        fileInputStream.close();
    }
}
