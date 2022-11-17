package com.fj.inputstream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 20:19    since 1.0.0             反序列化
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String filePath="d:\\data.txt";
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));
        //反序列化的顺序要和序列化一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog =ois.readObject();
        System.out.println(dog);
        System.out.println(dog.getClass());
        ois.close();
    }
}
