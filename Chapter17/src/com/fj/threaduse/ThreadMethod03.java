package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 14:07    since 1.0.0             守护线程
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDemoThread myDemoThread=new MyDemoThread();
        //主线程结束 子线程仍然在运行
        // 如果我们希望当主线程结束 子线程可以自动结束
        //只需将子线程设置为守护线程
        myDemoThread.setDaemon(true);
        myDemoThread.start();
        for (int i =1; i <=10 ; i++) {
            System.out.println("宝强在努力工作 ");
            Thread.sleep(1000);
        }



    }
}
class MyDemoThread extends Thread{
    @Override
    public void run() {
        for (;  ; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆在快乐聊天 哈哈哈····");
        }
    }
}
