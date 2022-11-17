package com.fj.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 21:25    since 1.0.0
 */
public class homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileReader("D:\\Java\\Chapter19\\src\\com\\fj\\homework\\dog.properties"));
        String name = properties.getProperty("name");
        int  age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //序列化dog对象
        String saveFilePath="D:\\Java\\Chapter19\\src\\com\\fj\\homework\\dog1.properties";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFilePath));
        oos.writeObject(dog);
        oos.close();//关闭流
    }
    //编写一个方法实现反序列化
    @Test
    public  void m1() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\Java\\Chapter19\\src\\com\\fj\\homework\\dog1.properties"));
        Dog dog=(Dog) ois.readObject();
        System.out.println("反序列化后"+dog);
        ois.close();
    }
}
class Dog implements Serializable{
    public String name;
    public int age;
    public String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}