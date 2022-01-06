package com.gxf;

/*
    Author: Whiplash
    Date: 2021/12/20 16:10
*/

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        FileInputStream fileInputStream = null;
        String filePath = "G:\\news1.txt";
        int readData;
        try {
            fileInputStream = new FileInputStream(filePath);
            while ((readData = fileInputStream.read()) != -1) { // 读取单个字节
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02() {
        FileInputStream fileInputStream = null;
        String filePath = "G:\\news1.txt";
        int readData;

        // 字节数组
        byte[] bt = new byte[6];

        try {
            fileInputStream = new FileInputStream(filePath);
            while ((fileInputStream.read(bt)) != -1) { // 每次读3个字节，-1表示读取完毕
                System.out.println(new String(bt, 0, bt.length)); // 显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void writeFile01() {
        String filePath = "G:\\output01.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 1. 没有会新建文件，有文件会覆盖原来的内容
            fileOutputStream = new FileOutputStream(filePath);

            // 2. 增量加，不覆盖
//            fileOutputStream = new FileOutputStream(filePath,true);

            // 写入一个字节
            fileOutputStream.write('H');

            //写入一个字符串
            String str = "Hello,world";
            fileOutputStream.write(str.getBytes()); // 字符串转化成字符数组
            fileOutputStream.write(str.getBytes(), 0, 3); // 字符串转化成字符数组

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyFile() {
        String srcFilePath = "C:\\Users\\Whiplash\\Desktop\\lisa.jpg";
        String destFilePath = "G:\\lisaLove.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            byte[] buf = new byte[1024];
            int readLen;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                // 一边读一边写
                // 一定要限制长度，否则可能导致最后读入空数据，图片无法显示
                fileOutputStream.write(buf,0,readLen);

            };

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
