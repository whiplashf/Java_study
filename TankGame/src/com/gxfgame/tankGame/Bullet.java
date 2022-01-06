package com.gxfgame.tankGame;

/*
    Author: Whiplash
    Date: 2021/12/17 21:37
*/

import java.awt.*;

public class Bullet extends Thread {
    int x;
    int y;
    int direction;
    int step_len = 3; //子弹每次走10格
    boolean isAlive = true;


    public void setStep_len(int step_len) {
        this.step_len = step_len;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
//            System.out.println(Thread.currentThread().getName()+" 运行中...");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direction) {
                case 0:
//                    System.out.println("向上发射！");
                    y -= step_len;
                    break;
                case 1:
                    x += step_len;
                    break;
                case 2:
                    y += step_len;
                    break;
                case 3:
                    x -= step_len;
                    break;
            }

            if(!(x>0 && x<1000 && y>0 && y<750 && isAlive)) { // isAlive很关键，如果不加，虽然图上不画了，但线程不会结束
                isAlive = false;
                System.out.println(Thread.currentThread().getName()+" 结束运行。");
                break;
            }
        }

    }
}
