package com.fj.reflection.question;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/26 21:45    since 1.0.0
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //使用properties类读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\Java\\Chapter23\\src\\com\\fj\\reflection\\re.properties"));
        String classfullpath= properties.getProperty("classfullpath").toString();
        String methodName=properties.getProperty("method").toString();

        //使用反射机制
        //加载类 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //通过cls得到加载到的类的对象实例
        Object o = cls.newInstance();
        System.out.println("运行类型"+o.getClass());
        //从配置文件中得到方法
        Method method = cls.getMethod(methodName);
        System.out.println("==========");
        //实现方法
        //传统方法 对象名.方法名 反射机制 方法.invoke(对象)
        method.invoke(o);
        //java.lang.reflect.Field 代表类的成员变量。Field对象表示某个类的成员变量
        Field nameFiled=cls.getField("age");
        //成员变量对象.get
        System.out.println(nameFiled.get(o));
        //java.lang.reflect.Field 代表类的构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);
        //代参构造器
        Constructor constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
    }
}
