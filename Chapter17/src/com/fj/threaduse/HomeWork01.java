package com.fj.threaduse;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 21:38    since 1.0.0
 */
public class HomeWork01 {

    public static void main(String[] args) {
        U u = new U();
        u.start();
        I i = new I(u);
        i.start();
    }
}

class U extends Thread{
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    private boolean loop=true;
    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
class I extends Thread {
    private U u;
    Scanner sc=new Scanner(System.in);
    public I(U u) {
        this.u = u;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q表示退出");
            char key = sc.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                u.setLoop(false);
                System.out.println("I 线程退出");
                break;
            }
        }
    }
}