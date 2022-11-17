package com.freeloop.innerclass;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02=new Outer02();
        outer02.m1();
        System.out.println("Outer02 hashcode"+outer02);
    }
}
class Outer02{
    private static int num=100;//私有属性
    private static void  m2(){//私有方法
        System.out.println("m2()");
    }

    public void m1(){
        //局部内部类经常定义在类的局部位置 通常是在方法
        //不能添加访问修饰符 但可以用final修饰
        //作用域只在定义它的方法内
        int num=800;
        class Inner02{
            public void f1() {
                //局部内部类可以直接访问外部内的所有成员 包括私有
                // Outer02.this 本质上就是一个外部类的一个对象 即哪个对象调用了m1()Outer02.this就是哪个对象
                System.out.println("内部类的num="+num+"外部类的num"+Outer02.this.num);
                m2();
                System.out.println("Outer02.this hashcode"+Outer02.this);

            }
        }
        //外部内在中 可以创建对象 调用方法即可
        Inner02 i1=new Inner02();
        i1.f1();
    }




}