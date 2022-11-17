package com.fj.jdbc.myjdbc;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/27 22:49    since 1.0.0
 */
public class TestJdbc {
    public static void main(String[] args) {
        JdbcInterface mysqlJdbc = new MysqlJdbcImpl();
        mysqlJdbc.getConnection();//通过接口来调用类 动态绑定
        mysqlJdbc.crud();
        mysqlJdbc.close();
    }
}
