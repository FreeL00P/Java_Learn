package com.fj.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 11:54    since 1.0.0
 */
public class Client03 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //发送文件名到服务端
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入一个文件名");
        String name=scanner.next();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(name.getBytes());
        socket.shutdownOutput();

        //将获取到的文件对应的字节数组写入到本地
        BufferedInputStream bis=new BufferedInputStream(socket.getInputStream());
        byte[] data=StreamUtils.streamToByteArray(bis);
        String filePath="e:\\"+name;
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(data);
        bis.close();

        bos.close();
        socket.close();
        outputStream.close();
    }
}
