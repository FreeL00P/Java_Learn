package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 22:10    since 1.0.0
 */
public class Homework02 {
    public static void main(String[] args) {
        User user = new User();
        Thread thread1 = new Thread(user);
        Thread thread2 = new Thread(user);
        thread1.start();
        thread2.start();
    }
}
class User implements Runnable{
    private int money=10000;
    private boolean loop=true;
    @Override
    public void run() {
        while (loop){
            // 这里使用synchronize实现了线程同步
            // 当多个线程执行到这里时 就会去争夺this对象锁
            // 哪个线程争夺到this对象锁 就执行 synchronize 代码块 执行完毕 释放this对象锁
            // 争夺不到的 暂时等待 阻塞在这里
            synchronized (this){if (money<=0){
                System.out.println("余额不足，不能取款");
                loop=false;
                return;
            }
                money-=1000;
                System.out.println(Thread.currentThread().getName()+"取款1000元成功，你的余额为"+money);
            }
        }
    }
}