package com.fj.transformation;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 12:14    since 1.0.0
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out=System.out;
        //在默认情况下  PrintStream 输出数据的位置是标准输出 即显示器
        //print源码 底层writer()
        out.println("Hello World");
        //底层writer() 直接调用writer
        out.write("hello world".getBytes());
        //修改打印输出的位置
        System.setOut(new PrintStream("d:\\f1.txt"));
        System.out.println("你好世界");//输出到文件
        out.close();
    }
}
