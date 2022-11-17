package com.fj.qqclient.server;

import com.fj.qqcommon.Message;
import com.fj.qqcommon.MessageType;
import com.fj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 21:27    since 1.0.0         该类完成用户登陆验证和用户注册等功能
 */
public class UserClientService {
    //我们可能会在其他地方使用user信息 验证该用户是否合法
    private User u=new User();
    //因为socket在其他地方也可能使用
    private Socket socket;
    //根据userId和pwd到服务器去验证用户是否合法
    public boolean checkUser(String userId,String pwd)  {
        boolean b=false;
        //创建user对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        //连接到服务端，发送u对象
        try {
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象
            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms=(Message) ois.readObject();
            //
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                //创建一个和服务器保持通信的线程-->创建一个类 ClientConnectServerThread
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                // 启动客户端线程
                clientConnectServerThread.start();
                //这里为了后面客户端的扩展，我们将线程放入到集合管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServerThread);
                b=true;
            }else {
                //如果登陆失败，我们就无法启动和服务器通信的线程 关闭socket
                System.out.println("登陆失败");
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    //向服务端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器
        try {
            //从管理线程的集合中 通过userId得到这个线程
            ClientConnectServerThread ccst = ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //通过这个线程得到socket 通过socket得到对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(ccst.getSocket().getOutputStream());
            oos.writeObject(message);//发送一个message对象，向服务端要在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //编写方法，退出客户端，并给服务端发送一个message对象
    public void logout(){
        Message message=new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//一定要指定我是哪个客户端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId()+"退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
