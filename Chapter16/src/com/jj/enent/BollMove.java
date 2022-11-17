package com.jj.enent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 14:14    since 1.0.0      小球通过键盘控制移动
 */
public class BollMove extends JFrame{
    MyPanel myPanel=null;
    public static void main(String[] args) {
        BollMove bollMove=new BollMove();
    }
    public BollMove(){
        myPanel=new MyPanel();
        this.add(myPanel);
        this.setSize(400,300);
        //窗口JFrame 对象可以监听键盘事件 既可以监听到面板发生的键盘事件
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//画出小球
//KeyListener  监听器 监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    int x=10;
    int y=10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }
    //有字符输出 该方法就会触发
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //当某个键按下 该方法触发
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode()+"被按下  " );
        //根据用户按下的键 控制小球的运行方向
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            y++;
        }else if (e.getKeyCode()==KeyEvent.VK_UP){
            y--;
        }else if (e.getKeyCode()==KeyEvent.VK_LEFT){
            x--;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            x++;
        }
        //让面板重新绘制
        this.repaint();
    }
    //当某个键松开 该方法触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
