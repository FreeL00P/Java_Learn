package com.fj.qqzone.service;

import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 12:12    since 1.0.0
 */
public interface UserBasicService {
    UserBasic login(String loginId ,String pwd);
    List<UserBasic> getFriendList(UserBasic userBasic);
    UserBasic getUserBasicById(Integer id);//根据id获取用户信息

}
