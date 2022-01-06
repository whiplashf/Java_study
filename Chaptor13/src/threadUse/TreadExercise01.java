package threadUse;

/*
    Author: Whiplash
    Date: 2021/12/17 10:26
*/

public class TreadExercise01 {
    public static void main(String[] args) throws InterruptedException{
        T t = new T();
        t.setName("Whiplash");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程
        t.setDaemon(true);

        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+" say: hi~" );
            if(i==4){t.join();}
            Thread.sleep(1000);
        }

        t.interrupt();//当执行到这里，就会中断 t线程的休眠.
    }
}

class T extends Thread { //自定义的线程类
    private int count = 0;
    @Override
    public void run() {
        while (count<20) {
            System.out.println(Thread.currentThread().getName() + " say: Hello~" );
            try {
                Thread.sleep(1000);//20秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
}