package com.fj.writer;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 15:29    since 1.0.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws Exception {
        String filePath="D:\\3.txt";
        //new FileWriter(filePath,true) 表示以追加的方式写入
        BufferedWriter bw= new BufferedWriter(new FileWriter(filePath,true));
        bw.write("HEllO");
        bw.newLine();
        bw.write("WORLD");
        bw.close();
    }
}
