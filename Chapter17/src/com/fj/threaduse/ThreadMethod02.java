package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 13:13    since 1.0.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        F2 f = new F2();
        f.setName("子线程1 ");//设置线程名
        f.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程吃包子   "+i);
            if (i==5){
                System.out.println("子线程先吃包子");
                f.join();//让子线程插队
                //Thread.yield();//线程礼让 cpu资源不足时才触发
                System.out.println("主线程接着吃"+i);
            }
        }

    }
}
class F2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" 吃包子   "+i);
        }
    }
}

