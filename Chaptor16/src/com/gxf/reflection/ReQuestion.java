package com.gxf.reflection;

/*
    Author: Whiplash
    Date: 2022/1/5 16:00
*/

import com.gxf.Cat;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReQuestion {
    public static void main(String[] args) throws Exception, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //传统的方式 new 对象 -》 调用方法
//        Cat cat = new Cat();
//        cat.hi(); ===> cat.cry() 修改源码.

        //我们尝试做一做 -> 明白反射

        //1. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\Re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);

//        Cat cat1 = new com.gxf.Cat();
//        Cat cat2 = new classfullpath();

        Class cls = Class.forName(classfullpath);
        System.out.println(cls.getClass()); // class java.lang.Class

        Object o = cls.newInstance(); // 必须要有无参构造器
        Method m = cls.getMethod(methodName);
        System.out.println(m.getClass()); // class java.lang.reflect.Method

        m.invoke(o); // 调用方法：方法.invoke(类)

        Field nameField = cls.getField("name"); // 只能访问public属性，不能访问私有和默认
        System.out.println(nameField.get(o));

//        Field ageFiled = cls.getField("age");
//        System.out.println(ageFiled);

        Constructor constructor = cls.getConstructor(); // 获取无参构造器对象
        System.out.println(constructor);
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
