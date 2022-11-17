package com.fj.qqzone.dao.impl;

import com.fj.myssm.basedao.BaseDAO;
import com.fj.qqzone.dao.UserBasicDAO;
import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 11:42    since 1.0.0
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId=? and pwd=?;",loginId,pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql="select fid as id from t_friend where uid=?";
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id=?",id);
    }
}
