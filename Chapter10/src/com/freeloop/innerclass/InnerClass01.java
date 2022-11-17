package com.freeloop.innerclass;

public class InnerClass01 {
    public static void main(String[] args) {

    }
}
class Outer{
    private int num=10;
    public void hello(){
        System.out.println("HELLO");
    }
    {
        num=101;
    }
    Outer(){

    }
    //内部类
    class Inner{

    }
}