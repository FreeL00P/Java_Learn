package com.fj.qqzone.dao.impl;

import com.fj.myssm.basedao.BaseDAO;
import com.fj.qqzone.dao.ReplyDAO;
import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:36    since 1.0.0
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplayList(Topic topic) {
        return executeQuery("select * from t_reply where topic=?",topic.getId());
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0,?,?,?,?)",reply.getContent(),reply.getReplyDate(),reply.getAuthor().getId(),reply.getTopic().getId());
    }

    @Override
    public void delReplay(Integer id) {
        executeUpdate("delete from t_reply where id=?",id);
    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id=?",id);
    }
}
