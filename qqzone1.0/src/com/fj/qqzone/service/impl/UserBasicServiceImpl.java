package com.fj.qqzone.service.impl;

import com.fj.qqzone.dao.UserBasicDAO;
import com.fj.qqzone.pojo.UserBasic;
import com.fj.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:14    since 1.0.0
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO=null;
    @Override
    public UserBasic login(String loginId, String pwd) {
        UserBasic userBasic=userBasicDAO.getUserBasic(loginId,pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicsList = userBasicDAO.getUserBasicList(userBasic);//查询的结果为 fid-List
        List<UserBasic> friendList =new ArrayList<>(userBasicsList.size());
        for (int i = 0; i <userBasicsList.size() ; i++) {
            UserBasic friend=userBasicsList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return  userBasicDAO.getUserBasicById(id);
    }

}
