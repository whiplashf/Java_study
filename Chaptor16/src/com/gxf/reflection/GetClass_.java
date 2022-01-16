package com.gxf.reflection;

/*
    Author: Whiplash
    Date: 2022/1/7 16:07
*/

import com.gxf.Cat;

public class GetClass_ {
    public static void main(String[] args) {
        Class cls1 = Cat.class;
        System.out.println(cls1);
        Class cls2 = Object.class;
        System.out.println(cls2);
    }
}
