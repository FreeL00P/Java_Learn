package com.fj.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 10:38    since 1.0.0
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath="d:\\1.txt";
        //1. 创建一个FileReader对象
        FileReader fileReader=null;
        int data=0;
        try {
            fileReader = new FileReader(filePath);
            //单个字符读取
            while ((data=fileReader.read())!=-1){
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
