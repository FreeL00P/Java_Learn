package com.fj.transformation;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 11:55    since 1.0.0
 * 把 FileOutputStream 字节流 转换为 OutputStreamWriter
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath="d:\\a=b.txt";
        String charSrt="utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSrt);
        osw.write("你好北京");
        osw.close();
        System.out.println("按照"+charSrt+"保存成功");
    }
}
