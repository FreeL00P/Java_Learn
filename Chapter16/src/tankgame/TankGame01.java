package tankgame;

import tankgame02.TankGame02;

import javax.swing.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:31    since 1.0.0      主程序
 */
public class TankGame01 extends JFrame {
    MyPanel myPanel=null;
    public static void main(String[] args) {
        TankGame01 tankGame01 = new TankGame01();
    }

    public TankGame01() {
        myPanel=new MyPanel();
        this.add(myPanel);
        this.setSize(100,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
