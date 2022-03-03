package com.gxf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Beginner {
    public static void main(String[] args) {
        String str = "我....我要....要要学学学学编程。";
        // 1 去点
        Pattern pattern1 = Pattern.compile("\\.");
        Matcher matcher1 = pattern1.matcher(str);
        String s1 = matcher1.replaceAll("");

        Pattern pattern2 = Pattern.compile("(\\S)\\1+");
        Matcher matcher2 = pattern2.matcher(s1);
        String s2 = matcher2.replaceAll("$1");
        System.out.println(s2);

        String phoneNum = "13675349878";
        System.out.println(Pattern.matches("1(?:36|89)\\d{8}", phoneNum));
        System.out.println(Pattern.matches("1(36|89)\\d{8}", phoneNum));
        System.out.println(Pattern.matches("1[36|89]\\d{8}", phoneNum));
    }
}

