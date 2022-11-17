package tankegame05;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:31    since 1.0.0      主程序
 */
public class TankGame05 extends JFrame {
    MyPanel myPanel=null;
    public static void main(String[] args) {
        TankGame05 tankGame05 = new TankGame05();
      /*  //初始化历史击毁敌人坦克数量
        try {
            Record.setWreckEnemyTankNum(Record.recordNum());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public TankGame05() {
        System.out.println("请输入选择 1：新游戏，2：继续上局游戏");
        Scanner scanner = new Scanner(System.in);
        String key= scanner.next();
        myPanel=new MyPanel(key);
        this.add(myPanel);
        Thread thread = new Thread(myPanel);
        thread.start();
        this.setSize(1000,750);
        //添加监听器
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //监听关闭窗口的处理事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到关闭窗口....");
                Record.recordScore();//调用存储击毁坦克数量到文件，保存当前敌人坦克信息的方法
                System.exit(0);
            }
        });
    }
}
