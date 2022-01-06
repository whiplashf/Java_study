package exception_;
/* 
    Author: whiplash
    Date: 2021/11/25 10:14
*/


public class ThrowException {
    public static void main(String[] args) {
        try {
            ReturnExceptionDemo.methodA();
        } catch (Exception e) {
            System.out.println("主程序catch...");
        } finally {
            System.out.println("主程序finally...");
        }

    }
}

class ReturnExceptionDemo {
    static void methodA() {
        try {
            String name = "jack";
            throw new RuntimeException("一个错误");
        } catch (Exception e) {
            System.out.println("进入到了Demo的catch中...");
        } finally {
            System.out.println("进入到了Demo的finally...");
        }
    }
}