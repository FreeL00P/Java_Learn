package com.fj.generic;

import java.util.ArrayList;

public class Generic02 {
    public static void main(String[] args) {
        //使用泛型
        //不满足要求被报错
        ArrayList<Dog> arrayList=new ArrayList<Dog>();
        arrayList.add(new Dog("jack",10));
        arrayList.add(new Dog("rose",20));
        arrayList.add(new Dog("gun",30));
        //不小心添加一只猫
       // arrayList.add(new Cat("猫",18));
        //遍历 可以直接取到Dog类型
        for (Dog dog: arrayList) {
            System.out.println(dog.getName()+dog.getAge());

        }
    }
}
class Dog{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
