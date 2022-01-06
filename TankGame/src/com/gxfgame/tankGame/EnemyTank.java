package com.gxfgame.tankGame;

/*
    Author: Whiplash
    Date: 2021/12/15 17:20
*/

import java.util.ArrayList;
import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }

    Vector<Bullet> bullets = new Vector<>();
    String tankName = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public String getTankName() {
        return tankName;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void shot() {
        Bullet bullet = new Bullet(getBulletX(), getBulletY(), getDirect());
        bullets.add(bullet);
        bullet.setName(Thread.currentThread().getName() + " 子弹" + bullets.indexOf(bullet));
        bullet.start();
    }

    public boolean isOverLapped() { // 防止敌人坦克重叠
        int edge = 0;
        for (int i = 0; i < enemyTanks.size(); i++) { // 只和前面确定位置的坦克比较(不行)
            EnemyTank enemyTank = enemyTanks.get(i);
            if(!enemyTank.isAlive) break;
            if (enemyTank == this) continue; // 不和自己比较
            //上下重叠
            if (this.getX() >= enemyTank.getX() - edge
                    && this.getX() <= enemyTank.getX() + enemyTank.getScope()[0] + edge
                    && this.getY() >= enemyTank.getY() - edge
                    && this.getY() <= enemyTank.getY() + enemyTank.getScope()[1] + edge) {
                return true;
            } else if (this.getX() + this.getScope()[0] >= enemyTank.getX() - edge
                    && this.getX() + this.getScope()[0] <= enemyTank.getX() + enemyTank.getScope()[0] + edge
                    && this.getY() >= enemyTank.getY() - edge
                    && this.getY() <= enemyTank.getY() + enemyTank.getScope()[1] + edge) {
                return true;
                // 左右重叠
            } else if (this.getX() >= enemyTank.getX() - edge
                    && this.getX() <= enemyTank.getX() + enemyTank.getScope()[0] + edge
                    && this.getY() + this.getScope()[1] >= enemyTank.getY() - edge
                    && this.getY() + this.getScope()[1] <= enemyTank.getY() + enemyTank.getScope()[1] + edge) {
                return true;
            } else if (this.getX() + this.getScope()[0] >= enemyTank.getX() - edge
                    && this.getX() + this.getScope()[0] <= enemyTank.getX() + enemyTank.getScope()[0] + edge
                    && this.getY() + this.getScope()[1] >= enemyTank.getY() - edge
                    && this.getY() + this.getScope()[1] <= enemyTank.getY() + enemyTank.getScope()[1] + edge) {
                return true;
            }
        }
        return false;
    }

    public boolean move(int direction) { // 返回值为是否在边界 在边界返回true
        setDirect(direction);
        switch (direction) {
            case 0:
                if (getY() <= 20 + getSpeed()) { //撞墙或者重叠了
                    return true;
                } //设置不能靠近边界20以内  调头量+步长
                if (!isOverLapped()) {
                    moveUp();
                } else {
                    setDirect(2);
                    setY(getY() + 2);
                }
                break;
            case 1:
                if (getX() >= 1000 - 60 - 20 - getSpeed()) {
                    return true;
                } // 1000为边界长度
                if (!isOverLapped()) {
                    moveRight();
                } else {
                    setDirect(3);
                    setX(getX() - 2);
                }
                break;
            case 2:
                if (getY() >= 750 - 60 - 20 - getSpeed()) {
                    return true;
                } // 750为边界高度
                if (!isOverLapped()) {
                    moveDown();
                } else {
                    setDirect(0);
                    setY(getY() - 2);
                }
                break;
            case 3:
                if (getX() <= 20 + getSpeed()) {
                    return true;
                }
                if (!isOverLapped()) {
                    moveLeft();
                } else {
                    setDirect(1);
                    setX(getX() + 2);
                }
                break;
        }
        return false;
    }


    @Override
    public void run() { // 每隔1秒发射一个子弹
        tankName = Thread.currentThread().getName();
        int shotCountDown = 0; // 记次器，记到一定数就发射子弹，保证发射子弹的间隔是相同的
        while (true) {

            setDirect((int) (Math.random() * 4)); // 随机选择方向，保存上一次的方向
//            int steps = (int) (Math.random() * 30 + 1); // 随机选择该方向的移动步数 1~10
            int steps = 30; // 固定步长30
            for (int i = 0; i < steps; i++) {

                // 结束语句
                if (!isAlive) return;

                shotCountDown++;
                // 如果撞墙了，就重新换方向
                // 如果重叠了，也要在这个方向尝试运动steps次数
                if (move(direct)) break;
                if (shotCountDown == 40) { // 40*50ms 射一次子弹
                    shot();
                    shotCountDown = 0;
                }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
