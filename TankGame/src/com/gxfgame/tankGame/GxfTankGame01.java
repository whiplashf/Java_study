package com.gxfgame.tankGame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class GxfTankGame01 extends JFrame {
    MyPanel mp = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GxfTankGame01 gxfTankGame01 = new GxfTankGame01();
    }

    public GxfTankGame01() {
        System.out.println("请选择 1 开始新游戏 2 继续上局游戏");
        int key = sc.nextInt();

        mp = new MyPanel(key);
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Thread thread = new Thread(mp);
        thread.start();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                System.out.println("窗口关闭");
                Recoder.keepRecord();
                System.exit(0); // 正常退出方法
            }
        });
    }

}
