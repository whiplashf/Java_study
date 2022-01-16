package com.gxf.reflection;

/*
    Author: Whiplash
    Date: 2022/1/6 17:06
*/

import com.gxf.Cat;
import org.junit.Test;

import java.lang.reflect.Method;

public class Reflection_time_test {
    static int time = 99999999;
    public static void main(String[] args) throws Exception{
        m1();
        m2();
        m3();
    }

    @Test
    public static void m1(){
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1()耗时 " + (end-start) + "ms");
    }

    @Test
    public static void m2() throws Exception{
        Class cls = Class.forName("com.gxf.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");

        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m2()耗时 " + (end-start) + "ms");
    }

    public static void m3() throws Exception{
        Class cls = Class.forName("com.gxf.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");
        method.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m3()耗时 " + (end-start) + "ms");
    }
}

