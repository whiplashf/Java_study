package threadUse;

/*
    Author: Whiplash
    Date: 2021/12/16 15:05
*/

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();

        System.out.println("主线程继续执行" + Thread.currentThread().getName());//名字main
        for(int i = 0; i < 30; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {

    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小猫咪"+(++times));
            try {
                Thread.sleep(1000); // 1000ms,1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
