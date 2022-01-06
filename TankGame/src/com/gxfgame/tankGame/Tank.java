package com.gxfgame.tankGame;

public class Tank {
    private int x, y;
    private boolean oldmanMode = true; // 老年模式，转向需要一步。默认开启。
    int speed = 1; // 每次移动的步长
    int direct; //0123 上右下左
    int lastDirect;
    int oppDirect;
    int width;
    int height;

    private int bulletX;
    private int bulletY;
    boolean isAlive = true;
    int deathCounting = 9; // 死亡残影会维持三次刷新
    boolean visible = true; // 目的是维持死亡残影


    public Tank(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    public int getOppDirect() {
        return (direct + 2) % 4;
    }

    public int[] getScope() {  // 获取占地面积。[宽度，高度]
        int[] scope = new int[2];
        if (direct == 0 || direct == 2) {
            scope[0] = 40;
            scope[1] = 60;
        } else if (direct == 1 || direct == 3) {
            scope[0] = 60;
            scope[1] = 40;
        }
        return scope;
    }

    public void findBullet() {
        switch (direct) {
            case 0:
                bulletX = x + 20;
                bulletY = y;
                break;
            case 1:
                bulletX = x + 60;
                bulletY = y + 20;
                break;
            case 2:
                bulletX = x + 20;
                bulletY = y + 60;
                break;
            case 3:
                bulletX = x;
                bulletY = y + 20;
                break;
        }
    }

    public void moveUp() {
        if (isAlive) y -= speed;
    }

    public void moveDown() {
        if (isAlive) y += speed;
    }

    public void moveLeft() {
        if (isAlive) x -= speed;
    }

    public void moveRight() {
        if (isAlive) x += speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) { // 使用setDirect会保存上一次的方向
        if (isAlive) {
            lastDirect = this.direct;
            this.direct = direct;
        }
    }

    public boolean isOldmanMode() {
        return oldmanMode;
    }

    public void setOldmanMode(boolean oldmanMode) {
        this.oldmanMode = oldmanMode;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getBulletX() { // 获取炮筒位置
        findBullet();
        return bulletX;
    }

    public int getBulletY() {
        findBullet();
        return bulletY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
