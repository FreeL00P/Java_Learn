package com.fj.qqzone.service.impl;

import com.fj.qqzone.dao.TopicDAO;
import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.ReplyService;
import com.fj.qqzone.service.TopicService;
import com.fj.qqzone.service.UserBasicService;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:32    since 1.0.0
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO=null;
    private ReplyService replyService;
    private UserBasicService   userBasicService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
    //根据id获取指定topic信息 包含这个topic关联的作者信息
    public Topic getTopic(Integer id){
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }
    @Override
    public Topic getTopicById(Integer id) {
        Topic topic=getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }

    @Override
    public void delTopic(Integer topicId) {
        Topic topic = topicDAO.getTopic(topicId);
        if (topic!=null){
            replyService.delReplyList(topic);//删除所有回复
            topicDAO.delTopic(topic);
        }

    }
}
