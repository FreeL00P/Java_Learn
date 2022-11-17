package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/14 21:46    since 1.0.0         通过实现 runnable接口 创建线程
 */
//通过实现 runnable接口 创建线程
public class Thread02{
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        //dog.strat(); //这里不能通过start()开启线程
        Thread thread=new Thread(dog);//创建了thread对象 把dog对象(实现Runnable) 放入Thread
        //thread.start();

        Proxy proxy = new Proxy(tiger);
        System.out.println(proxy.getClass());
        proxy.start();

        //子线程 与主线程 交替执行
        for (int i = 0; i <10 ; i++) {
            System.out.println("主线程执行中  "+i);
            Thread.sleep(1000);
        }

    }
}
class Dog implements Runnable{
    int times=0;
    @Override
    public void run() {
        while (true){
            System.out.println("狗叫  "+times);
            times++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times==10){
                break;
            }
        }
    }
}

class Animal{}

class Tiger extends Animal implements Runnable{
    int times=0;
    @Override
    public void run() {
        while (true){
            System.out.println("老虎叫  "+times);
            times++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times==10){
                break;
            }
        }
    }
}

//线程代理类
class Proxy implements Runnable{
    private Runnable target=null;
    @Override
    public void run() {
        if (target!=null){
            target.run();//动态绑定（运行类型 Tiger） 执行Tiger的run()方法
            System.out.println(target.getClass());
        }
    }

    public Proxy(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }

    private void start0() {
        run();
    }
}