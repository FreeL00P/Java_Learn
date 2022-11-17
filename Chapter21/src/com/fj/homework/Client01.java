package com.fj.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 22:44    since 1.0.0
 */
public class Client01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner sc=new Scanner(System.in);

        System.out.println("输入你的问题");
        String s = sc.next();
        bw.write(s);
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLen="";
        while ((readLen=br.readLine())!=null){
            System.out.println(readLen);
        }
        /*socket.shutdownInput();
        bw.write("hobby");
        bw.newLine();
        bw.flush();
        //socket.shutdownOutput();

        readLen="";
        while ((readLen=br.readLine())!=null){
            System.out.println(readLen);
        }
*/
        br.close();
        bw.close();
        socket.close();

    }
}
