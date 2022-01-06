package exception_;
/* 
    Author: whiplash
    Date: 2021/11/25 10:39
*/


import java.util.Scanner;

public class HW01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(50/2);
            System.out.print("请输入被除数：");
            String str1 = sc.next();
            System.out.print("请输入除数：");
            String str2 = sc.next();

            try {
                double n1 = Double.parseDouble(str1);
                double n2 = Double.parseDouble(str2);
                System.out.println(n1+"/"+n2+"="+n1/n2);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入错误，请重新输入");
            } catch (ArithmeticException e) {
                System.out.println("除数不能为0，请重新输入");
            }
        }
    }
}
