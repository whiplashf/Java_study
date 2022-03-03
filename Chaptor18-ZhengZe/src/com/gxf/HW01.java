package com.gxf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HW01 {
    public static void main(String[] args) {
        String email = "13399@qq.com";
        String regStr = "[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+";
        System.out.println(email.matches(regStr));

        String num = "123.5";
        String regStr2 = "^[-+]?([1-9]\\d*|0)(\\.\\d+)?$";
        System.out.println(num.matches(regStr2));

        String url = "http://www.sohu.com:8080/abc/index.htm";
        String regStr3 = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]+/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr3);
        Matcher matcher = pattern.matcher(url);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }


    }
}
