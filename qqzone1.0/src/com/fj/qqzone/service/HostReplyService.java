package com.fj.qqzone.service;

import com.fj.qqzone.pojo.HostReply;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:28    since 1.0.0
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);
    void delHostReply(Integer id);
}
