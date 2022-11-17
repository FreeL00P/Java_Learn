package com.fj.qqcommon;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/24 20:34    since 1.0.0
 */
public class User implements Serializable {
    private static final  long serialVersionUID=1L;
    private String userId;//用户id
    private String passwd;

    public User(String s, String s1) {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
