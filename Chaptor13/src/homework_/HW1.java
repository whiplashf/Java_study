package homework_;

/*
    Author: Whiplash
    Date: 2021/12/17 19:17
*/

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        DetectQ detectQ = new DetectQ();
        Thread thread = new Thread(printNum);
        thread.setDaemon(true);
        thread.start();
        new Thread(detectQ).start();
    }
}

class PrintNum implements Runnable {
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println((int) (Math.random() * 100));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DetectQ implements Runnable {
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {

        while (true){
            String str = sc.next();
            if(str.equals("q") || str.equals("Q")){
                break;
            }
        }
    }
}