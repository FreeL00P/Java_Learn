package com.fj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/28 20:59    since 1.0.0
 */
public class Homework01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection = DriverManager.getConnection(url, properties);
        Statement statement = connection.createStatement();
        String sql="Create table news(id int primary key,content varchar(32) not null);";
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "失败" : "成功");

    }
}
