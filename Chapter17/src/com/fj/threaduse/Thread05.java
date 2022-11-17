package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 9:55    since 1.0.0
 */
public class Thread05 {
    public static void main(String[] args) {
        SellTicket1 sellTicket = new SellTicket1();
        Thread t1=new Thread(sellTicket);
        Thread t2=new Thread(sellTicket);
        Thread t3=new Thread(sellTicket);
        t1.start();
        t2.start();
        t3.start();
    }
}
class SellTicket1 implements Runnable{
    int ticket=100;
    @Override
    public void run(){
        while (true){
            if (ticket<=0){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余"+(--ticket));
        }

    }
}

