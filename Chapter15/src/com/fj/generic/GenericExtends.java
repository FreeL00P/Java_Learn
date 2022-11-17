package com.fj.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 86185            2022/6/13 14:07    since 1.0.0      泛型继承
 */
public class GenericExtends {
    public static void main(String[] args) {
        Object o=new String("xx");
        //泛型没有继承性 Object-->父类 String -->子类
        //List<Object> list=new ArrayList<String>();
        List<Object> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        List<AA> list3=new ArrayList<>();
        List<BB> list4=new ArrayList<>();
        List<CC> list5=new ArrayList<>();
        //List<?> 可接收任何类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);
        //可以接收 AA或AA的子类
        //printCollection2(list1);
        //printCollection2(list2);
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        //支持AA以及AA类的父类
        printCollection3(list1);
        // printCollection3(list2);
        printCollection3(list3);
        // printCollection3(list4);
        //printCollection3(list5);
    }

    public static void  printCollection1(List<?> c){
        for (Object obj:c) {//调配符 取出时就是object
            System.out.println(obj);
        }
    }
    //<? extends AA>表示 上限 可以接收 AA或AA的子类
    public static void  printCollection2(List<? extends AA> c){
        for (Object obj:c) {//调配符 取出时就是object
            System.out.println(obj);
        }
    }
    // <? super AA> 表示 支持AA以及AA类的父类 规定了泛型的下限
    public static void  printCollection3(List<? super AA> c){
        for (Object obj:c) {//调配符 取出时就是object
            System.out.println(obj);
        }
    }
}
class AA{}

class BB extends AA{}

class CC extends BB{}
