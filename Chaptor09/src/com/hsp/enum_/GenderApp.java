package com.hsp.enum_;
/* 
    Author: whiplash
    Date: 2021/11/23 22:36
*/


public class GenderApp {
    public static void main(String[] args) {
        Gender boy1 = Gender.Boy;
        Gender girl1 = Gender.Girl;
        Gender unknown1 = Gender.Unknown;

        // .name() 返回当前对象名，子类不能重写（和toString一样嘛
        System.out.println(boy1.name());
        // .ordinal() 返回对象序号，从零开始排
        System.out.println("Boy的序号是："+boy1.ordinal()+"，Unknown的序号是："+unknown1.ordinal());
        // .values() 返回当前枚举类中所有常量
        Gender values[] = Gender.values();
        for (Gender g : values) {   // 增强for循环
            System.out.println(g);
        }
        // .valueOf() 根据name找到枚举类中的对象。如没有就会报错。
        Gender uk2 = Gender.valueOf("Unknown");
        System.out.println(uk2); // 返回叫这个名字的对象
        System.out.println(uk2 == unknown1); // 和上面的是同一个对象
        // .compareTo() 比较两个枚举常量的编号（自己减去other的序号）
        System.out.println(uk2.compareTo(unknown1));

        System.out.println(values[0]==boy1);


    }
}

enum Gender {
    Boy,Girl,Unknown;
}
