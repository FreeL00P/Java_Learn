package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 21:02    since 1.0.0
 */
public class Thread01{
    public static void main(String[] args) throws InterruptedException {
        //创建一个Cat对象 可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
        /*
        1.  public synchronized void start() {
            start0()
        }
        2. start0()是本地方法 是jvm调用 底层是c/c++实现
        3. 真正实现 多线程的方法是start0 而不是run()
        */
        // cat.run();//只是普通调用 没有真正启用一个线程 run()方法结束完毕 才向下执行

        //子线程 与主线程 交替执行
        for (int i = 0; i <10 ; i++) {
            System.out.println("主线程执行中  "+i);
            Thread.sleep(1000);
        }

    }
}
//1.当一个类继承了Thread类 该类就可以当线程使用
//2.重写run()方法，写上自己的业务逻辑
//3. run Thread类实现了runnable接口的run方法
class Cat extends Thread{
    @Override
    public void run() {//重写方法，写上自己的业务逻辑
        int times=0;
        while (true) {
            System.out.println("Hello World Cat "+times);
            times++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times==20){
                break;
            }
        }
    }
}
