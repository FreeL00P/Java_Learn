package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 20:20    since 1.0.0
 */
public class Thread06 {
    public static void main(String[] args) {
        SellTicket3 sellTicket3= new SellTicket3();

        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();
        new Thread(sellTicket3).start();

    }
}
class SellTicket3 extends Thread{
    int ticket=100;
    private boolean loop=true;
    public void run(){
        while (loop){
            sell();
        }
    }
    public synchronized void sell(){
        if (ticket<=0){
            System.out.println("售票结束....");
            loop=false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName()+"卖了一张票，剩余"+(--ticket));
    }
}