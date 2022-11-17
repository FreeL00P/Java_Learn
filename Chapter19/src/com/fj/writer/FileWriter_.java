package com.fj.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 10:56    since 1.0.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath="d:\\2.txt";
        FileWriter fileWriter = null;
        char[] chars={'a','b','c'};
        try {
            fileWriter=new FileWriter(filePath);
            fileWriter.write('A');//写入单个字符
            fileWriter.write(chars);//写入字符数组
            fileWriter.write("你好 世界");//写入字符串
            fileWriter.write("程序员".toCharArray(),0,1);//写入数组指定部分
            fileWriter.write("java",0,3);//写入字符串指定部分
            System.out.println("程序结束===");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //对于FileWriter一定要关闭流 才会把数据写入到文件
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
