package com.gxfgame.tankGame;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {

    boolean gameOver = false;
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    int enemyTankNum = 8;
    int enemyBirthX = 500;
    Bullet bullet = null;
    Image image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
    Image image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
    Image image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));


    public MyPanel(int key) {
        // 传入上局的敌人位置记录
        File file = new File(Recoder.getRecordPath());
        if (file.exists()) {
            nodes = Recoder.getNodes();
        } else {
            System.out.println("没有记录！开启新一局游戏");
            key = 1;
        }
        // 将MyPanel对象的enemyTanks设置给Recorder
        Recoder.setEnemyTanks(enemyTanks);
        // 初始化hero
        hero = new Hero(250, 250, 0, 10); // 设置初始位置方向和运动速度

        switch (key) {
            case 1:
                // 初始化敌人坦克
                for (int i = 0; i < enemyTankNum; i++) {
                    EnemyTank enemyTank = new EnemyTank(50 + 100 * i, 0, 2, 1); // 初始向下
                    Thread thread = new Thread(enemyTank);
                    thread.setName("enemy Tank-" + i + "号");
                    thread.start();
                    enemyTanks.add(enemyTank);
                    // 把所有敌人坦克数据传入，后续会同步更新
                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            case 2:
                //加载上局的敌人坦克
                for (int i = 0; i < nodes.size(); i++) {
                    EnemyTank enemyTank = new EnemyTank(nodes.get(i).x, nodes.get(i).y, nodes.get(i).d, 1);
                    Thread thread = new Thread(enemyTank);
//                    thread.setName("enemy Tank-" + i + "号");
                    thread.start();
                    enemyTanks.add(enemyTank);
                    // 把所有敌人坦克数据传入，后续会同步更新
                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            default:
                System.out.println("输入有误");
        }

        new AePlayWave("src\\111.wav").start();
    }

    public void showInfo(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        graphics.setFont(font);
        graphics.drawString("累计击毁敌方坦克数：", 1050, 30);

        graphics.drawString(Recoder.getDeadEnemyTankNum() + "", 1110, 90);
        drawTank(1050, 50, graphics, 0, 1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充背景(默认颜色好像是灰色？)
        g.fillRect(0, 0, 1000, 750);

        // 画计分板
        showInfo(g);

        // 画出hero坦克
        if (hero.isAlive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
            if (hero.xrayTime != 0) { // 发射了激光?
                int[] xray = hero.getXray();
                g.setColor(Color.orange);
                g.drawLine(xray[0], xray[1], xray[2], xray[3]);
                hero.xrayTime--;
                for (int i = 0; i < enemyTanks.size(); i++) { // 判断激光是否打中敌人
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.isAlive) {
                        isHittedByXray(hero.getBulletX(), hero.getBulletY(), hero.getDirect(), enemyTank);
                    }
                }
            }
            // 画出hero的子弹
            for (int i = 0; i < hero.bullets.size(); i++) {
                bullet = hero.bullets.get(i);
                if (bullet != null && bullet.isAlive) {
                    g.setColor(Color.cyan);
                    g.fill3DRect(bullet.x, bullet.y, 3, 3, false);

                    // 判断子弹有没有打到敌人
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        EnemyTank enemyTank = enemyTanks.get(j);
                        isHitted(bullet, enemyTank);
                    }
                }
            }
        }

        // 画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {  // 这里不用Num是因为坦克会被打掉
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isAlive) { // 坦克死了 子弹还在

                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);

            } else if (enemyTank.deathCounting != 0) { // 死亡坦克才能进入这个else 画出爆炸效果
                drawTankBoom(enemyTank, g);
                enemyTank.deathCounting--;
                System.out.println(enemyTank.getTankName() + "死亡倒计时: " + enemyTank.deathCounting);
            }

            // 画出敌人坦克的子弹
            boolean atLeastOneBulletAlive = false;
            for (int j = 0; j < enemyTank.bullets.size(); j++) { // 画出每个敌方坦克的子弹
                bullet = enemyTank.bullets.get(j);
                if (bullet != null && bullet.isAlive) {
                    atLeastOneBulletAlive = true;
                    g.setColor(Color.pink);
                    g.fill3DRect(bullet.x, bullet.y, 3, 3, false);

                    // 子弹是否击中hero
                    isHitted(bullet, hero);
                }
            }
            // 坦克死了吗?残影消失了吗?子弹都消失了吗? 三个条件都满足就可以remove了
            if (!enemyTank.isAlive && enemyTank.deathCounting == 0 && !atLeastOneBulletAlive) {  // 移除敌方坦克
                enemyTanks.remove(enemyTank); // 坦克的所有子弹打完，就remove
                i--; //回退一个下标
            }
        }

        // 只是让屏幕黑了 子弹线程和敌人线程都还没结束
        if (!hero.isAlive) {
            if (hero.deathCounting != 0) { // 死亡坦克才能进入这个else 画出爆炸效果
                drawTankBoom(hero, g);
                hero.deathCounting--;
            } else {
                g.setColor(Color.black);
                g.fillRect(0, 0, 1000, 750);
                g.setColor(Color.BLUE);
                g.setFont(new Font("a", Font.HANGING_BASELINE, 20));
                g.drawString("GameOver", 400, 330);
                gameOver = true;
            }
        }
    }


    /**
     * @param x      坦克左上角x坐标
     * @param y      坦克左上角y坐标
     * @param g
     * @param direct 方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人的坦克
                g.setColor(Color.pink);
                break;
        }

        //根据坦克方向，来绘制坦克
        // 0123 上右下左
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 9, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;

            case 3: //左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;

            default:
                System.out.println("暂时没有处理");
        }
    }

    public void drawTankBoom(Tank tank, Graphics g) {
        int x = tank.getX();
        int y = tank.getY();
        int direct = tank.getDirect();

        if (direct == 0 || direct == 2) {
            if (tank.deathCounting > 6)
                g.drawImage(image1, x, y, 40, 60, this); // this是啥意思
            else if (tank.deathCounting > 3)
                g.drawImage(image2, x, y, 40, 60, this);
            else if (tank.deathCounting > 0)
                g.drawImage(image3, x, y, 40, 60, this);

        } else {
            if (tank.deathCounting > 6)
                g.drawImage(image1, x, y, 60, 40, this); // this是啥意思
            else if (tank.deathCounting > 3)
                g.drawImage(image2, x, y, 60, 40, this);
            else if (tank.deathCounting > 0)
                g.drawImage(image3, x, y, 60, 40, this);

        }
    }

    public void isHitted(Bullet bullet, Tank tank) {
        if (tank.isAlive) {
            // 可以用switch，利用穿透
            if (tank.getDirect() == 0 || tank.getDirect() == 2) {  //如果是竖向的
                if (bullet.x >= tank.getX() && bullet.x <= tank.getX() + 40 &&
                        bullet.y >= tank.getY() && bullet.y <= tank.getY() + 60) {
                    bullet.isAlive = false;
                    tank.isAlive = false;
                    if (tank instanceof EnemyTank) {
                        Recoder.add();
                        System.out.println(((EnemyTank) tank).getTankName() + "被击毁！！");
                    }
                }
            } else if (tank.getDirect() == 1 || tank.getDirect() == 3) {  // 如果坦克是横向的
                if (bullet.x >= tank.getX() && bullet.x <= tank.getX() + 60 &&
                        bullet.y >= tank.getY() && bullet.y <= tank.getY() + 40) {
                    bullet.isAlive = false;
                    tank.isAlive = false;
                    if (tank instanceof EnemyTank) {
                        Recoder.add();
                        System.out.println(((EnemyTank) tank).getTankName() + "被击毁！！");
                    }
                }
            }
        }
    }

    public void isHittedByXray(int x, int y, int direction, Tank tank) {
        switch (tank.getDirect()) {
            case 0: // 当敌人坦克是竖向的
            case 2:
                if (direction == 0 && x > tank.getX() && x < tank.getX() + 40 && y >= tank.getY() + 60) {
                    tank.isAlive = false;
                }
                if (direction == 1 && y > tank.getY() && y < tank.getX() + 60 && x <= tank.getX()) {
                    tank.isAlive = false;
                }
                if (direction == 2 && x > tank.getX() && x < tank.getX() + 40 && y <= tank.getY()) {
                    tank.isAlive = false;
                }
                if (direction == 3 && y > tank.getY() && y < tank.getY() + 60 && x >= tank.getX() + 40) {
                    tank.isAlive = false;
                }
                if (!tank.isAlive) {
                    Recoder.add();
                }
                break;
            case 1: // 当敌人坦克是横向的
            case 3:
                if (direction == 0 && x > tank.getX() && x < tank.getX() + 60 && y >= tank.getY() + 40) {
                    tank.isAlive = false;
                }
                if (direction == 1 && y > tank.getY() && y < tank.getX() + 40 && x <= tank.getX()) {
                    tank.isAlive = false;
                }
                if (direction == 2 && x > tank.getX() && x < tank.getX() + 60 && y <= tank.getY()) {
                    tank.isAlive = false;
                }
                if (direction == 3 && y > tank.getY() && y < tank.getY() + 40 && x >= tank.getX() + 60) {
                    tank.isAlive = false;
                }
                if (!tank.isAlive) {
                    Recoder.add();
                }
                break;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) { //wasd和上下左右都可控制
            // 如果不是老年模式，或者是老年模式但已经正在本方向了，就移动
            hero.setDirect(2);
            if (hero.getY() < 750 - 60 - hero.speed) { //是否到达边界
                if (!(hero.isOldmanMode()) || hero.getDirect() == 2) { // 加了一个老年模式的判断
                    hero.moveDown();
                } // 下
//            System.out.println(e.getKeyCode());
            }

        } else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            if (hero.getY() > hero.getSpeed()) {
                if (!(hero.isOldmanMode()) || hero.getDirect() == 0) {
                    hero.moveUp();
                } // 上
//            System.out.println(e.getKeyCode());
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            if (hero.getX() > hero.speed) {
                if (!(hero.isOldmanMode()) || hero.getDirect() == 3) {
                    hero.moveLeft();
                } // 左
//            System.out.println(e.getKeyCode());
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            if (hero.getX() < 1000 - 60 - hero.speed) {
                if (!(hero.isOldmanMode()) || hero.getDirect() == 1) {
                    hero.moveRight();
                } // 右
//            System.out.println(e.getKeyCode());
            }
        } else if (e.getKeyCode() == KeyEvent.VK_J) { // 发射子弹
            hero.shotBullet();

        } else if (e.getKeyCode() == KeyEvent.VK_ADD) {  // 添加敌方坦克
            enemyBirthX += 50;
            EnemyTank enemyTank = new EnemyTank(enemyBirthX, 0, 2, 1);
            Thread thread = new Thread(enemyTank);
            thread.setName("Enemy Tank-" + (++enemyTankNum) + "号"); // 编号不重复，是历史上坦克的总数。
            thread.start();
            enemyTanks.add(enemyTank);
        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            hero.xrayTime = 5; // 激光维持的帧数
        }

        this.repaint();
    }

    @Override
    public void run() {  // 关键步骤 设置成线程的目的是能让他定时重绘
        while (!gameOver) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
