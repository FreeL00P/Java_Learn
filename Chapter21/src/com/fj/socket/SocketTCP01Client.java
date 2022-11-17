package com.fj.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 15:06    since 1.0.0
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //连接服务端 ip 端口
        // 如果连接成功 返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);
        System.out.println("客户端 socket 返回="+socket.getClass());
        //通过socket拿到输出流
        //得到和socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello 你好 server".getBytes());
        //关闭流对象和socket
        outputStream.close();
        socket.close();
    }
}
