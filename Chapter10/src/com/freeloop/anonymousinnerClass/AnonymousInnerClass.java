package com.freeloop.anonymousinnerClass;
/**
 * 匿名内部类
 * */
public class AnonymousInnerClass {
    public static void main(String[] args) {
    Outer03 outer03=new Outer03();
    outer03.method();
    }
}
class Outer03{
    private int n1=10;
    public void method(){
        //基于接口的匿名内部类
        //1.需求 使用IA接口并创建对象
        //2.传统方式，写一个类实现该接口，并创建对象
        //3. Tiger类是只使用一次 后面不在使用
//        IA tiger= new Tiger();
//        tiger.cry();
        //使用匿名内部类来简化开发
        //tiger的编译类型 IA
        //tiger的运行类型 就是匿名内部类 XXX -->Outer03$1
        /*
            底层
            class XXX implements IA{
                @Override
                public void cry() {
                    System.out.println("老虎叫.....");
                }
            }
        */
        // jdk底层在创建匿名内部类时 立即创建了Outer03$1实例
        // 并且把地址返回给 tiger
        // 匿名内部类使用一次 就不能再使用 对象可以反复使用
       IA tiger= new IA(){
           @Override
           public void cry(){
               System.out.println("老虎叫.....");
           }
        };
        System.out.println("tiger的运行类型"+tiger.getClass());
       tiger.cry();
       tiger.cry();
       tiger.cry();

       //基于类的匿名内部类
        Father father=new Father("java"){
            @Override
            public void test(){
                System.out.println("基于类的匿名内部类");
            }
        };
        father.test();
        System.out.println("father的运行类型"+father.getClass());

        //基于抽象类的匿名内部类
        Dog dog=new Dog() {
            @Override
            void eat() {
                System.out.println("狗吃屎");
            }
        };
        dog.eat();

    }
}
interface IA{
    public void cry();
}
//实现接口
/*class Tiger implements IA{
    @Override
    public void cry() {
        System.out.println("老虎叫.....");
    }
}
class Dog implements IA{

    @Override
    public void cry() {
        System.out.println("狗叫....");
    }
}*/
class Father{
    public Father(String name){//构造器

    }
    public void test(){//普通方法

    }
}
abstract class Dog{
    abstract void eat();
}