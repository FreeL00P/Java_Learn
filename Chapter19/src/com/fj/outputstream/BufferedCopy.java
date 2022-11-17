package com.fj.outputstream;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/19 19:29    since 1.0.0
 */
public class BufferedCopy {
    public static void main(String[] args) {
        String srcFilePath="d:\\1.jpg";
        String destFilePath="d:\\2.jpg";
        BufferedInputStream bis = null;
        BufferedOutputStream bos=null;

        try {
            //只能传入 InputStream的子类
            bis=new BufferedInputStream(new FileInputStream(srcFilePath));
            bos=new BufferedOutputStream(new FileOutputStream(destFilePath));
            //循环读取和写入
            byte[] buff=new byte[1024];
            int readLen=0;
            while ((readLen=bis.read(buff))!=-1){
                bos.write(buff,0,readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (bis!=null){
                    bis.close();
                }
                if (bos!=null){
                    bos.close();
                }
            }catch (IOException e){
                
            }

        }
    }
}
