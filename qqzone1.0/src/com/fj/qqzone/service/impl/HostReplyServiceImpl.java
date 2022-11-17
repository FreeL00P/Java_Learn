package com.fj.qqzone.service.impl;

import com.fj.qqzone.dao.HostReplyDAO;
import com.fj.qqzone.pojo.HostReply;
import com.fj.qqzone.service.HostReplyService;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:29    since 1.0.0
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;


    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
