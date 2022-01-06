package com.gxfgame.tankGame;

import java.util.ArrayList;

public class Hero extends Tank{

    public Hero(int x, int y, int d, int speed) {
        super(x, y, d, speed);
        super.setOldmanMode(false);

    }

    ArrayList<Bullet> bullets = new ArrayList<>();
    int xrayTime = 0;

    // 可以发射多个子弹了 还没考虑清理消亡子弹的问题
    public void shotBullet (){
        Bullet bullet = new Bullet(getBulletX(),getBulletY(),getDirect());
        bullets.add(bullet);
        bullet.start();
        bullet.setName("Hero Tank 子弹"+bullets.indexOf(bullet));
    }

    public int[] getXray(){
        int[] xray = new int[4];
        xray[0] = getBulletX();
        xray[1] = getBulletY();
        switch (getDirect()){
            case 0:
                xray[2] = getBulletX();
                xray[3] = 0;
                break;
            case 1:
                xray[2] = 1000;
                xray[3] = getBulletY();
                break;
            case 2:
                xray[2] = getBulletX();
                xray[3] = 750;
                break;
            case 3:
                xray[2] = 0;
                xray[3] = getBulletY();
                break;
        }
        return xray;
    }

    @Override
    public void setDirect(int direct) { // 避免转向时 激光跟着转
        super.setDirect(direct);
        xrayTime=0;
    }
}
