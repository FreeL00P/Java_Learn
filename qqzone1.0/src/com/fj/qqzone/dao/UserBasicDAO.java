package com.fj.qqzone.dao;
import com.fj.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/3 11:28    since 1.0.0
 */
public interface UserBasicDAO {
     UserBasic getUserBasic(String loginId,String pwd);
     List<UserBasic> getUserBasicList(UserBasic userBasic);
     //根据id查询UserBasicInfo
     UserBasic getUserBasicById(Integer id);
}
