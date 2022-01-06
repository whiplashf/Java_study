package com.gxfgame.tankGame;

/*
    Author: Whiplash
    Date: 2021/12/19 21:12
*/

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tst {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hello");
        arrayList.add("hi");
        A a = new A(arrayList);
        arrayList.add("dddd");
        System.out.println(a.arrayList);

        System.out.println("青岛真的好\r\n深圳");
    }

}
class A{
    ArrayList arrayList = null;

    public A(ArrayList arrayList) {
        this.arrayList = arrayList;
    }
}
