package com.fj.qqzone.service;

import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:17    since 1.0.0
 */
public interface ReplyService {
    //根据topic id获取关联的所有的回复
    List<Reply> getReplyListByTopicId(Integer topicId);
    void addReply(Reply reply);
    //删除指定回复
    void delReply(Integer replyId);
    //删除指定日志关联的所有回复
    void delReplyList(Topic topic);
}
