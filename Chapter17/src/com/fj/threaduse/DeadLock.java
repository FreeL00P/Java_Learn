package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 21:06    since 1.0.0
 */
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo A=new DeadLockDemo(true);
        DeadLockDemo B=new DeadLockDemo(false);
        A.start();
        B.start();
    }
}
class DeadLockDemo extends Thread{
    static Object o1=new Object();
    static Object o2=new Object();
    boolean flag;
    public DeadLockDemo(boolean flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        //如果flag 为T 线程就会先得到持有o1的对象锁
        //然后尝试拿取o2的锁 如果线程得不到o2对象锁 就会进行严格block
        if (flag){
            synchronized(o1) {//对象互斥锁 下面就是同步代码
                System.out.println(Thread.currentThread().getName() + "进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        }
        //如果flag 为F 线程就会先得到持有o2的对象锁
        //然后尝试拿取o1的锁 如果线程得不到o1对象锁 就会进行严格block
        else {
            synchronized(o2) {
                System.out.println(Thread.currentThread().getName() + "进入3");

                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}
