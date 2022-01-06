package exception_;
/* 
    Author: whiplash
    Date: 2021/11/24 15:39
*/


public class Exception01 {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 0;
        try {
            String s1 = "陆温馨";
            int a = Integer.parseInt(s1);
            System.out.println("数字："+a);
        } finally{
            System.out.println("finally...");
        }


        try {
            int res = n1/n2;
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("程序继续执行...");
    }
}

class A {

}
class B extends A {}
class C extends A {}