package com.fj.class_;

import com.fj.reflection.Cat;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/26 22:24    since 1.0.0
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        //看Class类图 Class也是类 继承了object
        //Class类对象不是new出来的 而是系统创建的
        //传统new对象
        /*public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }*/
        Cat cat = new Cat();
        //反射
        //仍然是通过
        /*public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
        }*/
        //加载类对象2

        Class cls = Class.forName("com.fj.reflection.Cat");
        Class cls1 = Class.forName("com.fj.reflection.Cat");
        //对于某个类的Class类对象 只会存在一份在堆里 只会加载一次
        System.out.println(cls.hashCode());
        System.out.println(cls1.hashCode());
        //每个对象的实例都会记得自己是由哪个Class所生成
        //可以通过Class对象得到一个类的完整结构 通过一系列的API
    }
}
