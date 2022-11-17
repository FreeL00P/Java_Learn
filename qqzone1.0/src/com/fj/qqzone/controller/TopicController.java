package com.fj.qqzone.controller;

import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 21:59    since 1.0.0
 */
public class TopicController {
    private TopicService topicService;
    public String topicDetail(Integer id, HttpSession session){
        Topic topic = topicService.getTopicById(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        //从session中获取当前用户信息
        UserBasic userBasic=(UserBasic) session.getAttribute("userBasic");
        // 再次查询与当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        //数组一下关联的日志列表 因为之前session中关联的friend的topicList与数据库中不一致
        userBasic.setTopicList(topicList);
        //重新覆盖一下friend中的信息 （为什么不覆盖userBasic因为main。html页面迭代的是friend这个key的数据）
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
}
