package com.gxfgame.event_;

/*
    Author: Whiplash
    Date: 2021/12/15 15:32
    演示小球通过键盘控制上下左右的移动-> 讲解Java的事件控制
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{

    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);

        //令窗口JFrame对象监听键盘事件, 即监听面板发生的键盘事件
        this.addKeyListener(mp);
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

class MyPanel extends JPanel implements KeyListener { // KeyListener键盘监听

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    //有字符输出时，该方法就会触发
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //当某个键按下，该方法会触发
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode()+"被按下...");
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if(e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        // 版面重绘
        this.repaint();
    }

    @Override
    //当某个键释放(松开)，该方法会触发
    public void keyReleased(KeyEvent e) {}
}

