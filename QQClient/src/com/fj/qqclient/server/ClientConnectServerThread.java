package com.fj.qqclient.server;

import com.fj.qqcommon.Message;
import com.fj.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 21:43    since 1.0.0
 */
public class ClientConnectServerThread extends Thread{
    //该线程需要持有Socket
    private Socket socket;
    //构造器可以接收一个Socket对象
    public ClientConnectServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        //因为Thread需要在后台与服务器通信，因此我们while循环
        while (true){
            System.out.println("客户端线程等待读取从服务器端发送的信息");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message= (Message) ois.readObject();//如果服务器没有发送Message对象，线程会阻塞在这里
                //判断这个message类型，然后做出对应的业务处理
                //如果是读取到的是服务端返回在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)){
                    //取出在线列表信息并显示
                    String[] onlineUser = message.getContent().split(" ");
                    System.out.println("==========当前在线用户列表如下==========");
                    for (int i = 0; i <onlineUser.length ; i++) {
                        System.out.println("用户："+onlineUser[i]);
                    }
                }else {
                    System.out.println("是其他类型的message暂不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //为了更方便的得到Socket 提供一个get方法
    public Socket getSocket() {
        return socket;
    }
}
