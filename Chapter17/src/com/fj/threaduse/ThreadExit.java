package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 12:22    since 1.0.0
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        System.out.println("main 线程休眠10秒");
        Thread.sleep(10*1000);
        t.setLoop(false);//

    }
}

class T extends Thread{
    private int count=0;
    private boolean loop=true;//设置一个控制变量

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){
            System.out.println("Hello World "+ count);
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}