package com.fj.reflection;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/26 21:43    since 1.0.0
 */
public class Cat {
    private String name;
    public int age=10;

    public Cat() {
        System.out.println("无参构造器");
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi(){
        //System.out.println("喵"+name+age);
    }
}
