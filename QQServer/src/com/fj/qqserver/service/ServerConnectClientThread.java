package com.fj.qqserver.service;

import com.fj.qqcommon.Message;
import com.fj.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 22:42    since 1.0.0         该类的一个对象和某个客户端保持通信
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {//线程处于run状态可以发送和接收信息
        while (true){
            System.out.println("服务端和客户端"+userId+"保持通信，读取数据");
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据message的类型 进行相应的业务处理
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    System.out.println(message.getSender()+"要在线用户列表");
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回一个message
                    Message message1 = new Message();
                    message1.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineUser);
                    message1.setGetter(message.getGetter());//发送者
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                }else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){
                    System.out.println(message.getSender()+"准备退出系统啦");
                    //将这个客户端对应的线程从集合中删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    //关闭socket
                    socket.close();
                    //退出线程(while循环)
                    break;
                }else {
                    System.out.println("其他message状态");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
