package com.fj.class_;

import com.fj.reflection.Cat;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/27 11:03    since 1.0.0
 * 演示得到Class对象的各种方式
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName
        String classAllPath="com.fj.reflection.Cat";
        Class<?> cls1=Class.forName(classAllPath);
        System.out.println(cls1);
        //类名.class应用场景：用于参数传递
        Class cls2= Cat.class;
        System.out.println(cls2);

        //对象.getClass() 应用场景 有对象实例
        Cat cat = new Cat();
        Class cls3=cat.getClass();
        System.out.println(cls3);

        //通过类加载器 得到Class对象
        //先得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //hashcode
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //基本数据类型 得到Class对象
        Class<Integer> cls5=int.class;
        Class<Boolean> cls6=boolean.class;

        //基本数据类型对应的包装类 可以通过.TYPE得到Class对象
        Class<Integer> cls7=Integer.TYPE;
        Class<Boolean> cls8=Boolean.TYPE;
        System.out.println(cls5.hashCode());
        System.out.println(cls7.hashCode());
    }
}
