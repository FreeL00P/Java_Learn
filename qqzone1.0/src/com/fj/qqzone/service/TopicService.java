package com.fj.qqzone.service;

import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:31    since 1.0.0
 */
public interface TopicService {
    //查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    Topic getTopicById(Integer id);//根据id获取日志信息
    //删除特定topic
    void delTopic(Integer topicId);
}
