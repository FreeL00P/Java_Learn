package com.fj.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/18 21:19    since 1.0.0         字节输入流
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile(){
        String filePath="d:\\news1.txt";
        FileInputStream fileInputStream=null;
        int read=0;
        //创建FileInputStream 用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
            //返回-1 表示读取完毕
            while ((read=fileInputStream.read())!=-1){
                System.out.println((char) read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //关闭文件流释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //使用read(byte[] b) 读取文件 提高效率
    public void readFile1(){
        byte[] buf = new byte[8];//每次读取一个字节数组的长度
        int readLen=0;
        String filePath="d:\\news1.txt";
        FileInputStream fileInputStream=null;
        //创建FileInputStream 用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
            //返回-1 表示读取完毕
            //如果读取正常 返回实际读取的字节数
            while ((readLen=fileInputStream.read(buf))!=-1){
                System.out.print(new String(buf,0,readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            //关闭文件流释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
