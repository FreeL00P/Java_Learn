package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 12:46    since 1.0.0
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        F f = new F();
        f.setName("王飞虎 ");//设置线程名
        f.setPriority(Thread.MIN_PRIORITY);//设置线程优先级
        f.start();


        //主线程 打印五次 hello 然后中断子线程的休眠
        for (int i = 0; i <5 ; i++) {
            Thread.sleep(1000);
            System.out.println("hello "+i);
        }
        f.interrupt();//中断f线程的休眠
    }
}
class F extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName()+" 吃包子   "+i);
            }
            try {
                System.out.println(Thread.currentThread().getName()+" 休眠中  ");
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                //InterruptedException 是捕获一个中断异常
                //当线程执行到interrupt()方法时 就会catch一个异常 可以加上自己的业务逻辑代码
                System.out.println(Thread.currentThread().getName()+" 被interrupt了  ");
            }
        }
    }
}

