package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 9:50    since 1.0.0      售票
 */
public class Thread04 {
    public static void main(String[] args) {
        SellTicket s1 = new SellTicket();
        SellTicket s2 = new SellTicket();
        SellTicket s3 = new SellTicket();
        s1.start();
        s2.start();
        s3.start();

    }
}
class SellTicket extends Thread{
    int ticket=100;
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
            System.out.println(currentThread().getName()+"卖了一张票，剩余"+(--ticket));
        }

    }
}
