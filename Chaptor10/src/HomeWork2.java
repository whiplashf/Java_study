/*
    Author: whiplash
    Date: 2021/11/29 21:23
*/


import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入用户名：");
        String name = sc.next();
        System.out.print("请输入用密码：");
        String passWord = sc.next();
        System.out.print("请输入邮箱：");
        String email = sc.next();
        try {
            userRegister(name,passWord,email);
            System.out.println("======信息输入成功！======");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void userRegister(String name, String passWord, String email) {
        if (name.length() < 2 || name.length() > 4) {
            throw new RuntimeException("用户名输入错误！");
        }

        if (passWord.length() != 6) {
            throw new RuntimeException("输入密码长度错误！");
        }
        Integer.parseInt(passWord);

        if (!(email.indexOf('@')>0 && email.indexOf('@')<email.indexOf('.'))) {
            throw new RuntimeException("邮箱输入有误！");
        }


    }
}

