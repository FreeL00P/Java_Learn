package com.fj.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 21:42    since 1.0.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象。准备在9998接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] data="Hello 明天看电影".getBytes();
        //说明：封装的对象 data 内容（字节数组） 长度，主机ip 端口
        DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);//发送数据

        byte[] buf=new byte[64*1024];
        packet = new DatagramPacket(buf,buf.length);
        socket.receive(packet);
        System.out.println("B端等待接收");

        //返回实际接收到的数据长度
        int length=packet.getLength();
        //接收到数据
        byte[] data1=packet.getData();
        String s = new String(data1, 0, length);
        System.out.println(s);

        socket.close();
        System.out.println("B端退出");
    }
}
