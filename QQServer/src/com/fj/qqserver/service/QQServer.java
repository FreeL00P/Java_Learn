package com.fj.qqserver.service;

import com.fj.qqcommon.Message;
import com.fj.qqcommon.MessageType;
import com.fj.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 22:22    since 1.0.0         这是服务器，在监听9999端口，等待客户端的连接，并保持通信
 */
public class QQServer {
    //
    private ServerSocket ss =null;
    //创建一个集合，存放多个用户，如果是这些用户登录就认为是合法的
    private static ConcurrentHashMap<String,User> validUsers=new ConcurrentHashMap<>();
    static {//在静态代码块初始化 validUser
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("至尊宝",new User("至尊宝","123456"));
        validUsers.put("紫霞仙子",new User("紫霞仙子","123456"));
        validUsers.put("菩提老祖",new User("菩提老祖","123456"));
    }
    //验证用户是否有效的方法
    private  boolean checkUser(String userId,String passwd){
        User user=validUsers.get(userId);
        if (user==null){//说明userId没有在validUser中的key
            return false;
        }
        //下面代码发生空指针异常
//        if (!(user.getPasswd().equals(passwd))){//密码错误
//            return true;
//        }
        return true;
    }
    public QQServer(){
        System.out.println("服务器9999端口正在监听...");
        try {
            ss=new ServerSocket(9999);
            while (true){//当和某个客户端连接后会继续监听 所以while
                Socket socket=ss.accept();
                //得到socket对象的输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u =(User) ois.readObject();//读取客户端发送的user对象
                //验证用户
                //创建一个Message对象准备回复客户端
                Message message=new Message();
                //得到socket关联的对象输出流
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                if (checkUser(u.getUserId(), u.getPasswd())){
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将message对象回复给客户端
                    oos.writeObject(message);
                    //创建一个线程和客户端保持一个通讯，该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    serverConnectClientThread.start();
                    //把该线程对象放入一个集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(),serverConnectClientThread);
                }else {//登陆失败
                    System.out.println("用户 id="+u.getUserId()+"密码 pwd="+u.getPasswd()+"验证失败");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //关闭socket
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端退出了while，说明服务端不在监听，因此需要关闭serverSocket
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
