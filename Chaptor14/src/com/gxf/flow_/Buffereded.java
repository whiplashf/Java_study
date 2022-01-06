package com.gxf.flow_;

/*
    Author: Whiplash
    Date: 2021/12/21 16:04
*/

import java.io.*;

public class Buffereded {
    public static void main(String[] args) {
        String filePath = "F:\\JAVA_FILE\\IDEA_File\\Chaptor14\\src\\com\\gxf\\FileCreate.java";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
