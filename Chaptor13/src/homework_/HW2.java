package homework_;

/*
    Author: Whiplash
    Date: 2021/12/17 19:57
*/

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account).start();
        new Thread(account).start();
    }
}

class Account implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        draw();
    }

    public void draw() {


        while (true) {
            synchronized (this) {
                if (money <= 0) {
                    System.out.println("取没了");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000，余额：" + money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
