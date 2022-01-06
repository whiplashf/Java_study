package com.gxf.flow_;

/*
    Author: Whiplash
    Date: 2021/12/22 11:59
*/

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) throws IOException {
        String path = "G\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

        oos.write(100);
        oos.writeUTF("hell");

        System.out.println();

    }
}


