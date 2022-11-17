package com.fj.fileCopy;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 18:20    since 1.0.0
 */
public class TCPFileCopyClient {
    public static void main(String[] args) throws Exception {
        //连接服务端 ip 端口
        // 如果连接成功 返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回="+socket.getClass());
        String filePath="D:\\1.jpg";
        //读取文件输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes=StreamUtils.streamToByteArray(bis);//返回一个filePath对应的字节数组
        //通过socket发送bytes到服务端
        BufferedOutputStream bos=new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的数组内容写入到数组通道
        bis.close();
        socket.shutdownOutput();//写入数据的结束标记

        //用于接收服务端返回的信息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);//将InputStream读到你内容转换为字符串
        System.out.println(s);

        inputStream.close();
        bos.close();
        socket.close();



    }

}
