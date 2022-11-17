package com.fj.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/29 12:28    since 1.0.0
 * 完成连接mysql和关闭资源
 */
public class JDBCUtils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    //初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Java\\Chapter25\\src\\com\\fj\\jdbc\\mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //将编译异常 转换为运行时异常
            throw new RuntimeException(e);
        }
    }
    //连接数据库
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //关闭相关资源
    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
