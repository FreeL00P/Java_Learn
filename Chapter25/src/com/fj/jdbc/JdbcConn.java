package com.fj.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/28 14:57    since 1.0.0
 * java连接mysql的五种方式
 */
public class JdbcConn {
    @Test
    public void connect01() throws SQLException {
        //创建driver对象
        Driver driver = new Driver();
        //连接到数据库的地址
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //2 得到连接
        Connection connect = driver.connect(url, properties);
        System.out.println("方式1 " + connect);
    }

    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //2 得到连接
        Connection connect = driver.connect(url, properties);
        System.out.println("方式2 " + connect);
    }

    //使用DriverManger替代 Driver
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //注册Driver驱动
        DriverManager.registerDriver(driver);
        //2 得到连接
        Connection connection = DriverManager.getConnection(url, properties);

        System.out.println("方式3 " + connection);
    }

    @Test
    public void connect04() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类 使用Class.forName自动完成注册驱动
        //在加载Driver时完成注册
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbcDB";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //2 得到连接
        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println("方式4 " + connection);
    }
}