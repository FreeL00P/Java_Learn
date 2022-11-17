package com.fj.transformation;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 11:28    since 1.0.0         中文乱码问题
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        String filePath="d:\\a.txt";
        //创建字符流
        //BufferedReader br=new BufferedReader(new FileReader(filePath));
        BufferedReader br=new BufferedReader(new FileReader(filePath));

        String s= br.readLine();
        //默认读取文件默认是按照utf-8 文件是ansi编码
        System.out.println("读取到的内容"+s);//helloworld�������

        br.close();

    }
    }
