package com.fj.qqcommon;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 20:44    since 1.0.0             表示消息类型
 */
public interface MessageType {
    //在接口中定义一些常量
    // 不同的值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED="1";//表示登陆成功
    String MESSAGE_LOGIN_FAIL="2";//表示登陆失败
    String MESSAGE_COMM_MES="3";//普通的信息
    String MESSAGE_GET_ONLINE_FRIEND="4";//要求返回在线列表
    String MESSAGE_RET_ONLINE_FRIEND="5";//返回在线列表
    String MESSAGE_CLIENT_EXIT="6";//客户端请求退出

}
