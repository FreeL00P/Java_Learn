package com.fj.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 11:42    since 1.0.0
 */
public class Server03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket=serverSocket.accept();
        InputStream inputStream=socket.getInputStream();//获取客户端发来的文件名
        byte[] b=new byte[1024];
        int len=0;
        String name="";
        while ((len=inputStream.read(b))!=-1){
            name+=new String(b,0,len);
        }

        String filePath="";
        if ("1".equals(name)){
            filePath="d:\\1.jpg";
        }else {
            filePath="d:\\0.jpg";
        }

        System.out.println(filePath);
        //将获取到的文件写入管道
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
        byte[] data=StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        bos.write(data);
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
