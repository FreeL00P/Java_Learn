package com.fj.qqzone.service.impl;

import com.fj.qqzone.dao.ReplyDAO;
import com.fj.qqzone.pojo.HostReply;
import com.fj.qqzone.pojo.Reply;
import com.fj.qqzone.pojo.Topic;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.HostReplyService;
import com.fj.qqzone.service.ReplyService;
import com.fj.qqzone.service.UserBasicService;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 22:19    since 1.0.0
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replayList = replyDAO.getReplayList(new Topic(topicId));
        for (int i = 0; i < replayList.size(); i++) {
            Reply reply=replayList.get(i);
            //将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);
            //将关联的HostReply设置进去
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replayList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }
    @Override
    public void delReply(Integer replyId) {
        //根据id获取回复
        Reply reply = replyDAO.getReply(replyId);

        if (reply!=null){
            //如果reply有关联的hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if (hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
            replyDAO.delReplay(replyId);
        }
    }
    
    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replayList = replyDAO.getReplayList(topic);
        if (replayList!=null){
            for (Reply reply : replayList) {
                delReply(reply.getId());
            }
        }
    }
}
