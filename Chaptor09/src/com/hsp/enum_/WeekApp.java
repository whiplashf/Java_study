package com.hsp.enum_;
/* 
    Author: whiplash
    Date: 2021/11/23 23:18
*/


import jdk.internal.instrumentation.InstrumentationMethod;

import java.lang.annotation.Inherited;

public class WeekApp {
    public static void main(String[] args) {
        Week[] week = Week.values();
        for(Week w : week){
            System.out.println(w.getDesc());
        }
    }
}

enum Week {
    Monday("星期一"),Tuesday("星期二"), Wednesday("星期三");

    private String desc;

    private Week(String desc) {
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }

    public String toString() {
        return "Week{" +
                "desc='" + desc + '\'' +
                '}';
    }
}