package com.fj.generic;

import com.sun.prism.impl.shape.BasicRoundRectRep;

import java.util.ArrayList;

//public class Generic01 {
//    public static void main(String[] args) {
//        ArrayList arrayList=new ArrayList();
//        arrayList.add(new Dog("jack",10));
//        arrayList.add(new Dog("rose",20));
//        arrayList.add(new Dog("gun",30));
//        //不小心添加一只猫
//        arrayList.add(new Cat("猫",18));
//        for (Object o: arrayList) {
//            //向下转型
//            Dog dog=(Dog) o;
//            System.out.println(dog.getName()+dog.getAge());
//
//        }
//    }
//}
//class Dog{
//    private String name;
//    private int age;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Dog(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//}
