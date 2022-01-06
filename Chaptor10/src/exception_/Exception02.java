package exception_;
/* 
    Author: whiplash
    Date: 2021/11/24 22:22
*/


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception02 {
    public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入一个整数：");
            String str = sc.next();
            try {
                int n = Integer.parseInt(str);
                System.out.println("你输入了" + n);
                break;
            } catch (NumberFormatException e) {
                System.out.println("整数谢谢");
            }
        }
    }
}

