package com.use;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        A a = new B(); // 运行类型是B
        System.out.println(a.sum());   // 20 + 10 = 30
        System.out.println(a.sum1());  // 10 + 10 = 20
        String str[] = {};
        System.out.println(str.length);
        System.out.println("a的运行类型是"+a.getClass());

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s);



    }
}



class A {

    public int i = 10;

    public int sum() {
        return getI() + 10; // getI会去调用B中的
    }

    public int getI() { // 子类getI()
        return i;
    }

    public int sum1() {
        return i + 10;
    }

}

class B extends A { // 子类
    public int i = 20;

    public int getI() { // 子类getI()
        return i;
    }
}