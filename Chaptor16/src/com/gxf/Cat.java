package com.gxf;

/*
    Author: Whiplash
    Date: 2022/1/5 15:55
*/

public class Cat {

    int age = 10;
    public String name = "咬人猫";
    public String hobby = "chiyu";

    public Cat(){

    }

    public Cat(String name){
        this.name = name;
    }

    public void hi(){

//        System.out.println("hello~咬人猫~");
    }

    public void cry(){
        System.out.println("呜呜呜...");
    }
}
