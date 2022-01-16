package com.gxf.classLoad_;

/*
    Author: Whiplash
    Date: 2022/1/8 18:53
*/

import java.lang.reflect.Constructor;

public class Load01 {
    public static void main(String[] args) {
        System.out.println(B.num);
        Class cls = B.class;
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}

class A {
    int a = 0;
    public A(int a){
        this.a = a;
    }

    public A() {
        System.out.println("构造器A");
    }
}

class B extends A{

    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }
    
    static int num = 100;
    int id = 0;

    public B(int a, int id) {
        super(a);
        this.id = id;

    }

//    public B(int i){
//        id=i;
//    }
    
}
