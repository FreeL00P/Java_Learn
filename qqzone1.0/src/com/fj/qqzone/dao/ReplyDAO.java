package com.fj.qqzone.dao;

import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 11:38    since 1.0.0
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplayList(Topic topic);
    //添加回复
    void addReply(Reply reply);
    //删除回复
    void delReplay(Integer id);
    //根据id获取指定reply
    Reply getReply(Integer id);
}
