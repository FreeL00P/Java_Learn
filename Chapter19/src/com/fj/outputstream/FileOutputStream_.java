package com.fj.outputstream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/18 21:42    since 1.0.0
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void writeFile(){
        FileOutputStream fileOutputStream = null;
        String filePath="D:\\1.txt";
        byte[] buf = new byte[8];
        File file = new File(filePath);
        if (file.exists()){
            try {
                fileOutputStream=new FileOutputStream(filePath,true);
                String str="Hello World";
                fileOutputStream.write(str.getBytes(),0,str.length());
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeFile();
        }

    }
}
