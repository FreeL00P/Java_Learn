package com.fj.reflection.question;

import com.fj.reflection.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/26 22:05    since 1.0.0
 * 反射的性能和优化
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }
    //传统方法调用方法hi
    public static void m1(){
        Cat cat = new Cat();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.hi();
        }
        long end=System.currentTimeMillis();
        System.out.println("传统方法耗时"+(end-start));
    }
    //反射机制调用方法hi
    public static void m2() throws Exception {
        //加载类 返回Class类型的对象cls
        Class cls = Class.forName("com.fj.reflection.Cat");
        //通过cls得到加载到的类的对象实例
        Object o = cls.newInstance();
        //从配置文件中得到方法
        Method method = cls.getMethod("hi");
        long start=System.currentTimeMillis();

        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);
        }
        long end=System.currentTimeMillis();
        System.out.println("反射耗时"+(end-start));
    }

    public static void m3() throws Exception {
        //加载类 返回Class类型的对象cls
        Class cls = Class.forName("com.fj.reflection.Cat");
        //通过cls得到加载到的类的对象实例
        Object o = cls.newInstance();
        //从配置文件中得到方法
        Method method = cls.getMethod("hi");
        //优化 取消反射调用方法的访问检测
        method.setAccessible(true);
        long start=System.currentTimeMillis();

        for (int i = 0; i < 900000000; i++) {
            method.invoke(o);
        }
        long end=System.currentTimeMillis();
        System.out.println("反射优化耗时"+(end-start));
    }
}
