package com.fj.class_;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>
 * 冯俊        2022/6/27 11:36    since 1.0.0
 * 演示哪些类型有class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1=String.class;
        Class<Serializable> cls2=Serializable.class;
        Class<Integer[]> cls3=Integer[].class;
        Class<float[][]> cls4=float[][].class;
        Class<Deprecated> cls5=Deprecated.class;
        //枚举
        Class<Thread.State> cls6=Thread.State.class;
        Class<Long> cls7=long.class;//基本数据类型
        Class<Void> cls8=void.class;//void数据类型
        Class<Class> cls9=Class.class;
        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
