package com.fj.qqzone.controller;

import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.TopicService;
import com.fj.qqzone.service.UserBasicService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:39    since 1.0.0
 */
public class UserController extends HttpServlet {
    private UserBasicService userBasicService;
    private TopicService topicService;
    public String login(String loginId , String pwd, HttpSession session){
        //登陆验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic!=null){
            List<UserBasic> friendList=userBasicService.getFriendList(userBasic);//返回好友列表
            List<Topic> topicList=topicService.getTopicList(userBasic);//返回日志列表
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            session.setAttribute("userBasic",userBasic);//登陆者的想信息
            session.setAttribute("friend",userBasic);//空间主人信息
            return "index";
        }else {
            return "login";//登陆失败
        }
    }
    public String friend(Integer id,HttpSession session){
        //根据id获取指定用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend",currFriend);
        return "index";
    }
}
