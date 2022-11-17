package com.fj.homework;

import java.io.IOException;
import java.net.*;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 11:17    since 1.0.0
 */
public class SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9998);
        byte[] data="四大名著是哪些".getBytes();
        DatagramPacket packet=new DatagramPacket(data,data.length, InetAddress.getLocalHost(),9999);
        socket.send(packet);

        packet=new DatagramPacket(data,data.length);
        socket.receive(packet);
        data=packet.getData();
        int length=packet.getLength();
        String s = new String(data, 0, length);
        System.out.println(s);
        socket.close();
    }
}
