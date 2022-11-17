package com.fj.draw;

import com.sun.javaws.util.JfxHelper;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/13 22:26    since 1.0.0      如何在面板上画圆
 */
public class DrawCircle extends JFrame {
    //定义一个面板
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle(){
        //初始化面板
        mp=new MyPanel();
        //把面板放入到窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(400,300);
        //输入退出 点击 X 退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}


//定义一个MyPanel 继承JPanel类 画图形
//MyPanel对象是一个画板
//Graphics是一只笔
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类方法完成初始化
        System.out.println("paint方法 被调用了");
 /*       //绘制圆
        g.drawOval(100,100,200,200);
        //画直线
        g.drawLine(100,100,200,200);
        //画矩形边框
        g.drawRect(10,10,100,100);
        //填充矩形
        //设置画笔颜色
        g.setColor(Color.pink);
        g.fillRect(10,10,100,100);
        g.fillOval(100,100,200,200);
        //画图片
        //获取图片资源
        Image image=  Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/0photo.jpg"));
        g.drawImage(image,200,200,175,221,this);*/
        //写字
        g.setColor(Color.red);
        g.setFont(new Font("隶书",Font.BOLD,50));
        g.drawString("Hello World 你好 世界",100,100);
    }
}