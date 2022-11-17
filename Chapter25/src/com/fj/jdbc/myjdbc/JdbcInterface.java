package com.fj.jdbc.myjdbc;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/27 22:45    since 1.0.0
 */
public interface JdbcInterface {
    //连接
    public Object getConnection();
    //crud
    public void crud();
    //关闭连接
    public void close();
}
