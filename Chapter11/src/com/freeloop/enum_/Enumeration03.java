package com.freeloop.enum_;

public class Enumeration03 {
    public static void main(String[] args) {
        Gender2 boy=Gender2.BOY;
        Gender2 boy2=Gender2.BOY;
        System.out.println(boy);//输出BOY //本质就是调用Gender2的父类Enum的toString方法
        System.out.println(boy==boy2);// true
    }
}
enum Gender2{
    BOY,GIRL;
}