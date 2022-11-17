package com.fj.homework;

import java.io.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 19:02    since 1.0.0
 */
public class homework02 {
    public static void main(String[] args) {
        String filePath="D:\\1.txt";
        BufferedReader br = null;
        String readLine="";
        int lineNum=1;
        try{
            br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"gbk"));
            System.out.println(br.readLine());
            while ((readLine= br.readLine())!=null){
                System.out.println(lineNum+readLine);
                lineNum++;
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                if (br!=null){
                    br.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
