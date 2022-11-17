package com.fj.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 20:05    since 1.0.0       演示ObjectOutputStream序列化 的使用
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        String filePath="d:\\data.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到 data
        oos.writeInt(100); //int -->Integer 实现了Serializable接口
        oos.writeBoolean(true);
        oos.writeChar('a');
        oos.writeDouble(9.5);//double -->Double 实现了serializable
        oos.writeUTF("你好世界");//保存字符串
        oos.writeObject(new Dog("鸡哥",27));
        oos.close();
    }
}
class Dog implements Serializable {
    public String name;
    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}