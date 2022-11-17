package com.fj.File;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/18 20:40    since 1.0.0
 */
public class FileInfo {
    public static void main(String[] args) {

    }
    //获取文件信息
    @Test
    public void info(){
        File file = new File("d:\\news1.txt");
        System.out.println("文件名字："+file.getName());
        System.out.println("绝对路径"+file.getAbsolutePath());
        System.out.println("父目录："+file.getParent());
        System.out.println("文件大小"+file.length());
        System.out.println("文件是否存在"+file.exists());
        System.out.println("是否是文件"+file.isFile());
        System.out.println("是否是一个目录"+file.isDirectory());
    }
}
