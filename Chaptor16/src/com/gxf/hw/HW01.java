package com.gxf.hw;

/*
    Author: Whiplash
    Date: 2022/1/8 21:58
*/

import java.lang.reflect.Field;

public class HW01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class cls = PrivateTest.class;
        Object o = cls.newInstance();
        Field nameField = cls.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(o, "Ana");
        System.out.println(((PrivateTest) o).getName());
    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
