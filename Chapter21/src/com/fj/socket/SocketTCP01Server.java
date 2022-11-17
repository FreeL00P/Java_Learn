package com.fj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 15:00    since 1.0.0
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //在本机的9999端口监听 等待连接 要求本机没有其他服务在监听9999
        //serverSocket 可以通过accept返回多个socket [多个客户端来连接服务器的并发]
        ServerSocket serverSocket=new ServerSocket(9998);
        System.out.println("服务端在监听 9998，等待连接");
        //当没有客户端连接9999端口时 阻塞 等待连接
        //如果有客户端连接，则会返回一个socket对象
        Socket socket=serverSocket.accept();
        System.out.println("服务端 socket="+socket.getClass());
        //通过socket.getInputStream读取
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] buf=new byte[1024];
        int readLen=0;
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        //关闭流和socket serverSocket
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
