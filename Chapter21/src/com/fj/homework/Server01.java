package com.fj.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 22:36    since 1.0.0
 */
public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(9999);
        Socket socket=serverSocket.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLen="";
        readLen=br.readLine();
        socket.shutdownInput();
        String answer="";
        if ("name".equals(readLen)){
            answer="我是 Nova";
        }else if ("hobby".equals(readLen)){
            answer="编写java程序";
        }else {
            answer="你说的什么";
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bw.write(answer);
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
        socket.close();
        serverSocket.close();


    }
}
