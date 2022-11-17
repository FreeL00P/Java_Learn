package com.fj.qqzone.dao;

import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 11:36    since 1.0.0
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    void addTopic(Topic topic);
    //删除日志
    void delTopic(Topic topic);
    //获取特定日志信息
    Topic getTopic(Integer id);
}
