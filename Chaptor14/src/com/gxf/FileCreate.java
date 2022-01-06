package com.gxf;

/*
    Author: Whiplash
    Date: 2021/12/20 14:57
*/

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileCreate {
    public static void main(String[] args) {
        File file = new File("g:\\啥也不是"); // 磁盘中有就读取 没有就在内存中创建（不会写到磁盘）

        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F

        file.mkdirs();

    }

    //方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "g:\\news1.txt"; // 写出完整的路径+文件内名
        File file = new File(filePath); // new File 在内存中创建

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent,String child) //根据父目录文件+子路径构建
    @Test
    public void creat02(){
        File parentFile = new File("G:\\"); //先创建目录文件
        String fileName = "news2.txt";
        System.out.println("创建成功！");
        File file = new File(parentFile, fileName); // 输入目录文件+文件名  在内存中创建

        try {
            file.createNewFile();  // 输出到磁盘中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:\\";
        String parentPath = "G:\\";  // 先创建目录路径
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName); // 输入目录路径+文件名

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
