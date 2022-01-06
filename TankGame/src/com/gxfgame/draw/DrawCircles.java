package com.gxfgame.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircles extends JFrame {
    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircles();
        System.out.println("退出程序~");
    }

    public DrawCircles() {//构造器
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口的大小
        this.setSize(900, 600);

        //下面这条语句使得，当点击窗口的×，程序完全退出。否则就算叉掉也不会释放资源。
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);//可以显示
    }
}

class MyPanel extends JPanel {
    //说明:
    //1. MyPanel 对象就是一个画板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘图的方法
    //Graphics g
    @Override
    public void paint(Graphics g) { //绘图方法
        super.paint(g); //调用父类的方法完成初始化.
//        System.out.println("paint 方法被调用了~");

        // 画出圆形,直线,矩形
        g.drawOval(10, 10, 100, 100); // ⚪左上角（10，10）
        g.drawLine(10,10,110,110);
        g.drawRect(10,10,100,100);

        // 设置颜色，画填充图形
        g.setColor(Color.orange);
        g.fillRect(100,100,10,10);
        g.fillOval(120,120,10,10);

        // 放图片，根目录在F:\JAVA_FILE\IDEA_File\TankGame\out\production\TankGame
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/lisa.jpg"));
        g.drawImage(image,130,130,1225,683,this);

        // 画字符串
        g.setFont(new Font("楷书",Font.BOLD,50));
        g.drawString("Lisa Love!",500,125);
    }
}