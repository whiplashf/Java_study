package com.gxf.reflection;

/*
    Author: Whiplash
    Date: 2022/1/7 15:50
*/

import java.lang.reflect.Field;

public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String classAllPath = "com.gxf.Cat";
        //1 . 获取到Car类 对应的 Class对象
        //<?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        Object o = cls.newInstance();

        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.get(o)); // 值
        }
    }
}
