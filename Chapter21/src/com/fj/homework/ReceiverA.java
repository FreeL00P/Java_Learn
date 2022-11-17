package com.fj.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 11:16    since 1.0.0
 */
public class ReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);
        byte[] bytes=new byte[1024*64];
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        byte[] data=packet.getData();
        int length= packet.getLength();
        String s=new String(data,0,length);
        System.out.println(s);
        String answer="";
        if ("四大名著是哪些".equals(s)){
            answer="四大名著是红楼梦";
        }else {
            answer="what?";
        }
        data=answer.getBytes();
        packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet);//发送数据
        socket.close();
    }
}
