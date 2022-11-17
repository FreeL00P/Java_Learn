package com.fj.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 21:29    since 1.0.0
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));//转化为字符流 使用处理流
        bw.write("hello server 字符流");
        bw.newLine();//插入一个换行符 表示写入结束 (读方必须使用readLine读取 否则一样无法结束)
        bw.flush();//如果使用字符流 必须手动刷新 否则无法写入socket
        //接收服务端的信息
        InputStream inputStream= socket.getInputStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));//转化为字符流 在使用处理流
        String readLen="";
        readLen=br.readLine();
        System.out.println(readLen);

        socket.close();
        bw.close();
        br.close();
}
}
