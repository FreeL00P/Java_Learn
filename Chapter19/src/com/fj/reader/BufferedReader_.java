package com.fj.reader;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 15:16    since 1.0.0
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        String filePath="d:\\1.txt";
        //创建BufferedReader对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        // 按行读取
        String line;
        //当返回null时 表示文件读取完毕
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        //只需要关闭BufferedReader流 底层会自动关闭FileReader节点流
        bufferedReader.close();
    }
}
