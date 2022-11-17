package com.fj.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 20:27    since 1.0.0
 */
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("服务端正在监听9999端口");
        Socket socket=serverSocket.accept();
        InputStream inputStream= socket.getInputStream();
        int readLen=0;
        byte[] buf=new byte[1024];
        while ((readLen=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,readLen));
        }
        socket.shutdownInput();
        //发送信息给客户端
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());

        serverSocket.close();
        inputStream.close();
        socket.close();
        outputStream.close();
    }
}
