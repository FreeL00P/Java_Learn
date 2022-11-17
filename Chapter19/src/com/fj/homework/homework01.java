package com.fj.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 18:43    since 1.0.0
 */
public class homework01 {
    public static void main(String[] args) throws IOException {
        String filePath="e:\\myTemp";
        String filePath2=filePath+ "\\hello.txt";
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("文件已经存在");
        }else{
            if(file.mkdir()){
                System.out.println(filePath+"创建成功");
            }
        }
        file = new File(filePath2);
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println(filePath2+"创建成功");
                BufferedWriter bwf=new BufferedWriter(new FileWriter(filePath2));
                bwf.write("hello world");
                System.out.println("写入成功");
                bwf.close();//一定要关闭流
            }else {
                System.out.println(filePath2+"创建失败");
            }
        }else {
            System.out.println(filePath2+"文件已经存在");
        }

    }
}
