package com.fj.qqclient.server;

import java.util.HashMap;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 21:58    since 1.0.0         管理客户端连接到服务端线程的一个类
 */
public class ManageClientConnectServerThread {
    //将多个线程放入HashMap集合中 key就是用户id value就是线程
    private static HashMap<String,ClientConnectServerThread> hm=new HashMap<>();
    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hm.put(userId,clientConnectServerThread);
    }
    //通过userId可以得到线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }

}
