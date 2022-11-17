package com.fj.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/23 21:41    since 1.0.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象 在9999端口接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //创建一个DatagramPacket对象，准备接受数据
        byte[] buf=new byte[64*1024];
        DatagramPacket packet = new DatagramPacket(buf,buf.length);
        //调用接收方法
        //将通过网络传输的DatagramPacket对象，填充到packet对象
        //当接收到packet对象时，需要进行拆包。才能取出到数据并显示
        //当有数据包发送到本机的9999端口，就会接收到数据
        // 如果没有数据包发送，则会阻塞等待
        System.out.println("A端等待接收");
        socket.receive(packet);
        //返回实际接收到的数据长度
        int length=packet.getLength();
        //接收到数据
        byte[] data=packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        byte[] data1="好的 明天见".getBytes();
        //说明：封装的对象 data 内容（字节数组） 长度，主机ip 端口
        packet = new DatagramPacket(data1, data1.length, InetAddress.getLocalHost(), 9998);
        socket.send(packet);//发送数据
        socket.close();
        System.out.println("A端退出");
    }
}
