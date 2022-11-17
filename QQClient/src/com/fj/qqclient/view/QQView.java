package com.fj.qqclient.view;

import com.fj.qqclient.server.UserClientService;
import com.fj.qqclient.utility.Utility;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 20:51    since 1.0.0     客户端的菜单页面
 */
public class QQView {
    private boolean loop=true;//用于控制是否显示菜单
    private String key="";
    //该对象用于登陆服务器，注册用户
    private UserClientService userClientService=new UserClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }
    //显示主菜单
    private void mainMenu(){
        while (loop){
            System.out.println("==========欢迎登陆网络通信系统==========");
            System.out.println("\t\t 1 登陆系统");
            System.out.println("\t\t 9 退出系统");
            key = Utility.readString(1);
            //根据用户的输入来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.print("请输入用户号：");
                    String userId=Utility.readString(50);
                    System.out.print("请输入密  码：");
                    String pwd=Utility.readString(50);
                    //需要到服务器去判断用户是否合法
                    if (userClientService.checkUser(userId,pwd)){//先把逻辑打通
                        System.out.println("==========欢迎用户("+userId+")登陆成功==========");
                        //进入到二级菜单
                        while (loop){
                            System.out.println("\n==========网络通信系统二级菜单("+userId+")==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择");
                            key=Utility.readString(1);
                            switch (key){
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    loop=false;
                                    break;
                            }
                        }
                    }else {
                        System.out.println("==========登陆失败==========");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    loop=false;
                    break;
            }
        }
    }
}
