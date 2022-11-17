package com.fj;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 15:41    since 1.0.0
 */
public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\3.txt"));
        BufferedWriter bw= new BufferedWriter(new FileWriter("D:\\3(1).txt",true));
        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
