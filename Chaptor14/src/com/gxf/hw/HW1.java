package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2021/12/26 21:21
*/

import java.io.*;

public class HW1 {
    public static void main (String[] args) throws IOException {
        String path = "f:\\mytemp\\";
        String fileName = "hello.txt";
        File directory = new File(path);
        File file = new File(path, fileName);

        if(!directory.exists()){
            directory.mkdir();
        }

        if(file.createNewFile()){
            System.out.println(path+fileName+" 创建成功！");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path+fileName));
            bufferedWriter.write("hello, gxf!");
            bufferedWriter.close();
        } else {
            System.out.println(path+fileName+" 已经存在！");
        }


    }
}
