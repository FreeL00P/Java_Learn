package com.fj.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 21:30    since 1.0.0
 */
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("服务端正在监听9999端口");
        Socket socket=serverSocket.accept();
        InputStream inputStream= socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));//转化为字符流 在使用处理流
        String readLen="";
        readLen=br.readLine();
        System.out.println(readLen);


        socket.shutdownInput();
        //发送信息给客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));//转化为字符流 使用处理流
        bw.write("hello client 字符流");
        bw.newLine();//插入一个换行符 表示写入结束 (读方必须使用readLine读取 否则一样无法结束)
        bw.flush();//如果使用字符流 必须手动刷新 否则无法写入socket
        serverSocket.close();
        br.close();
        socket.close();
        bw.close();
    }
}
