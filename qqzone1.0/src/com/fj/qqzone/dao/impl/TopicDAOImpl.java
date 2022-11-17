package com.fj.qqzone.dao.impl;

import com.fj.myssm.basedao.BaseDAO;
import com.fj.qqzone.dao.TopicDAO;
import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:05    since 1.0.0
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author =?",userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {
        super.executeUpdate("delete from t_topic where id=?",topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return super.load("select * from t_topic where id=?",id);
    }
}
