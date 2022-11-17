package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 9:28    since 1.0.0
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1=new Thread(t1);
        Thread thread2=new Thread(t2);
        thread1.start();
        thread2.start();

    }
}

class T1 implements Runnable{
    int count=0;
    @Override
    public void run() {
      while (true){
            System.out.println("Hello World "+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count==10){
                break;
            }
        }
    }
}

class T2 implements Runnable{
    int count=0;
    @Override
    public void run() {
        while (true){
            System.out.println("Hi "+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count==5){
                break;
            }
        }
    }
}
