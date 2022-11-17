package com.fj.File;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/18 20:48    since 1.0.0
 */
public class Dir_ {
    public static void main(String[] args) {

    }

    //判断文件是否存在 存在则删除
    @Test
    public void m1(){
        String filePath="d:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("文件不存在");
        }
    }
    //判断目录是否存在
    @Test
    public void m2(){
        String filePath="d:\\test";
        File file = new File(filePath);
        if (file.exists()){
            if (file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("不存在");
        }
    }

    @Test
    public void m3(){
        String filePath="d:\\test\\test1\\test2";
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("该目录存在");
        }else {
            //创建
            if (file.mkdirs()){
                System.out.println("创建成功");
            }else {
                System.out.println("创建失败");
            }
        }
    }
}
