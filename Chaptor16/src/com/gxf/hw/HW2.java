package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/8 22:07
*/


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HW2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class cls = Class.forName("java.io.File");
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor c1 = cls.getConstructor(String.class);
        Object o = c1.newInstance("s:\\怎么个红了.txt");
        Method m1 = cls.getMethod("createNewFile");
        m1.invoke(o);
    }
}
