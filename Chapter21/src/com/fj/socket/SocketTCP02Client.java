package com.fj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 20:27    since 1.0.0
 */
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello server".getBytes());

        socket.shutdownOutput();
        //接收服务端的信息
        InputStream inputStream= socket.getInputStream();
        int readLen=0;
        byte[] buf=new byte[1024];
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        socket.close();
        outputStream.close();
        inputStream.close();
    }
}
