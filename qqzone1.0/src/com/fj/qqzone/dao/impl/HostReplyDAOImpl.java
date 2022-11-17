package com.fj.qqzone.dao.impl;

import com.fj.myssm.basedao.BaseDAO;
import com.fj.qqzone.dao.HostReplyDAO;
import com.fj.qqzone.pojo.HostReply;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:31    since 1.0.0
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return super.load("select * from t_host_reply where reply=?",replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id=?",id);
    }
}
