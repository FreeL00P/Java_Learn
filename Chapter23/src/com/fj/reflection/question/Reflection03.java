package com.fj.reflection.question;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.security.PublicKey;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/27 15:35    since 1.0.0      演示如何通过反射获取类的信息
 */
public class Reflection03 {
    public static void main(String[] args) {

    }
    @Test
    public void api_01() throws ClassNotFoundException {
        //得到class对象
        Class<?> personCls=Class.forName("com.fj.reflection.question.Person");
        //获取全类名
        System.out.println(personCls.getName());
        //获取简单名
        System.out.println(personCls.getSimpleName());
        //获取所有public修饰的属性包括父类属性
        Field[] fileds=personCls.getFields();
        System.out.println("本类和父类的属性");
        for (Field filed : fileds) {
            System.out.println(filed.getName());
        }

    }

}
class A{
    public String sex;
}
class Person{
    public String name;
    protected int age;
    private double sal;
    public void m1(){

    }
    protected void m2(){

    }
    private void m3(){

    }
    void m4(){

    }
}