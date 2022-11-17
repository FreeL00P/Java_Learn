package com.fj.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 14:37    since 1.0.0         创建修改Properties
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //创建
        //如果该文件没有key，则创建
        //如果该文件有key  则是修改
        //父类和底层是HashTable
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");
        properties.setProperty("pwd","acc111");
        //将k-v存储文件中即可
        properties.store(new FileWriter("D:\\Java\\Chapter19\\src\\mysql1.properties"),null);
        System.out.println("保存成功");
    }
}
