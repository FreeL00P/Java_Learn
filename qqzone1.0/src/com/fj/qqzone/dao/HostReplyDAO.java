package com.fj.qqzone.dao;

import com.fj.qqzone.pojo.HostReply;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 11:41    since 1.0.0
 */
public interface HostReplyDAO {
    //根据replyId查询关联的reply实体
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
}
