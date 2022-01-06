package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2021/12/26 21:56
*/

import java.io.*;

public class HW2 {
    public static void main(String[] args) throws IOException {
        String path = "f:\\mytemp\\hello.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path),"gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int lineNum = 1;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println((lineNum++) + " " + line);
        }
        bufferedReader.close();
    }
}
