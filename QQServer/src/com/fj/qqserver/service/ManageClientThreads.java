package com.fj.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 22:51    since 1.0.0      该类用于管理和客户端通信的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hm=new HashMap<>();
    //添加线程对象到hm集合
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
    //根据userId返回一个线程
    public ServerConnectClientThread getServerConnectClientThread(String userId){
        return  hm.get(userId);
    }
    //返回在线用户列表
    public static String getOnlineUser(){
        //遍历hm的key
        String onlineUserList= "";
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            onlineUserList+=iterator.next().toString()+" ";
        }

        return  onlineUserList;
    }
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }
}
