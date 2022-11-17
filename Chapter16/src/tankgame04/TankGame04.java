package tankgame04;

import javax.swing.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 13:31    since 1.0.0      主程序
 */
public class TankGame04 extends JFrame {
    MyPanel myPanel=null;
    public static void main(String[] args) {
        TankGame04 tankGame04 = new TankGame04();
    }

    public TankGame04() {
        myPanel=new MyPanel();
        this.add(myPanel);
        Thread thread = new Thread(myPanel);
        thread.start();
        this.setSize(1000,750);
        //添加监听器
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
