package com.fj.fileCopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 18:20    since 1.0.0
 */
public class TCPFileCopyServer {
    public static void main(String[] args) throws Exception {
        //监听9999端口
        ServerSocket serverSocket=new ServerSocket(9999);
        //如果有客户端连接，则会返回一个socket对象
        Socket socket=serverSocket.accept();//等待连接
        System.out.println("服务端 socket="+socket.getClass());
        //通过socket.getInputStream()读取 客户端发来的数据
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //拿到传过来的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //将得到的bytes数组写入到指定路径
        String filePath="D:\\Java\\Chapter21\\src\\1.jpg";//存储路径
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);
        bos.close();
       // socket.shutdownInput();

        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");//向客户端发送信息
        writer.flush();//字符流需要刷新 把内容刷新到数据通道
        socket.shutdownOutput();

        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
