package com.fj.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 12:24    since 1.0.0
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("Hi BeiHai");
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("d:\\f.txt"));
        printWriter1.println("NI HAO");//输出到文件
        printWriter.close();
        printWriter1.close();
    }
}
