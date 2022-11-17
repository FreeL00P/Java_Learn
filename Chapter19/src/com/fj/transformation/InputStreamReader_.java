package com.fj.transformation;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 11:44    since 1.0.0             InputStreamReader解决中文乱码问题
 * 将字节流转换为字符流
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath="d:\\a.txt";
        //将FileInputStream 转换为字符流 InputStreamReader 指定编码gbk
        //InputStreamReader isr= new InputStreamReader(new FileInputStream(filePath),"gbk");
        //把InputStreamReader 放入处理流 BufferedReader
        //BufferedReader br = new BufferedReader(isr);
        //合二为一
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
        //读取
        String s=br.readLine();
        System.out.println(s);
        //关闭流
        br.close();//只需关闭外层流
    }

}
