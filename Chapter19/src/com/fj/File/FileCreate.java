package com.fj.File;

import org.junit.jupiter.api.Test;
import sun.security.mscapi.CPublicKey;

import java.beans.Transient;
import java.io.File;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/18 20:20    since 1.0.0      演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    //方式1 new File(path);
    @Test
    public void create01(){
        String path="D:\\news1.txt";
        File file = new File(path);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //方式2 new File(File parent,String child) //根据父目录文件+子路径构建
    public void create02(){
        File parentFile = new File("D:\\");
        String filename="news2.txt";
        File file1 = new File(parentFile, filename);
        try {
            file1.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方式3
    @Test
    public void create03(){
        String parentPath="D:\\";
        String fileName="news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
