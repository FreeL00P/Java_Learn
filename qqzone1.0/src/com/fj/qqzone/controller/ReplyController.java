package com.fj.qqzone.controller;

import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/4 14:41    since 1.0.0
 */
public class ReplyController {
    private ReplyService replyService;
    public String addReply(String content, Integer topicId, HttpSession session){
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content,new Date(),author ,new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
    public String delReply(Integer replyId,Integer topicId){
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}
