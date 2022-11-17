package com.fj.reader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 10:44    since 1.0.0
 */
public class FileReader_1 {
    public static void main(String[] args) {
        String filePath = "d:\\1.txt";
        //1. 创建一个FileReader对象
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf=new char[8];
        try {
            fileReader = new FileReader(filePath);
            //单个字符读取
            while ((readLen=fileReader.read(buf)) != -1) {
                System.out.print(new String(buf,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}