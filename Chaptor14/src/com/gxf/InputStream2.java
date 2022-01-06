package com.gxf;

/*
    Author: Whiplash
    Date: 2021/12/20 20:19
    字符流读写
*/

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputStream2 {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01(){
        String filePath = "G:\\news1.txt";
        FileReader fileReader = null;
        int data;

        try {
            fileReader = new FileReader(filePath);

                while ((data = fileReader.read())!=-1){
                    System.out.println((char)data);
                }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void fileWriter(){
        String filePath = "G:\\output2.txt";
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write("岂曰无衣，与子同袍");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

