package com.fj.threaduse;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/15 19:58    since 1.0.0
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        System.out.println(a.getName()+" 状态 "+a.getState());
        a.start();
        while (Thread.State.TERMINATED!=a.getState()){
            System.out.println(a.getName()+" 状态 "+a.getState());
            Thread.sleep(500);
        }
        System.out.println(a.getName()+" 状态 "+a.getState());
    }
}

class A extends Thread{
    @Override
    public void run() {
        while (true){
            for (int i = 0; i <10 ; i++) {
                System.out.println("Hello World"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}
