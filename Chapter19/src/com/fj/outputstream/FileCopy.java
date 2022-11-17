package com.fj.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 9:58    since 1.0.0      文件复制
 */
public class FileCopy {
    public static void main(String[] args) {
        String srcFilePath="e:\\1.jpg";
        String destFilePath="D:\\1.jpg";
        //创建文件输入流，将文件读入到程序
        FileInputStream fileInputStream=null;
        //创建文件输出流，将读取到的文件数据，写入到指定的文件
        FileOutputStream fileOutputStream=null;
        try {
           fileInputStream=new FileInputStream(srcFilePath);
           fileOutputStream=new FileOutputStream(destFilePath );
           //定义字节数组 提高效率
            byte[] buf=new byte[1024];
            int readLen=0;
            while ((readLen=fileInputStream.read(buf))!=-1){
                //读取后 写入文件
                //即边读边写
                fileOutputStream.write(buf,0,readLen);//一定要使用个方法
            }
            System.out.println("拷贝成功===");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }catch (IOException e){

            }

        }

    }
}
