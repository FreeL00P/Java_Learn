package com.fj.jdbc.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/30 14:59    since 1.0.0
 */
public class C3P0_ {
    //在程序中指定相关的参数
    @Test
    public void testC3P0_01() throws IOException, PropertyVetoException, SQLException {
        //创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        //通过配置文件读取相关链接信息
        properties.load(new FileInputStream("D:\\Java\\Chapter25\\src\\com\\fj\\jdbc\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //给数据源设置相关参数
        // 我们连接管理是由  comboPooledDataSource. 管理
        //设置连接驱动
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);//设置连接地址
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数量
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //连接5000次
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 5000次连接mysql "+(end-start));
    }

    //使用配置文件模板来完成连接
    @Test
    //将c3p0提供的配置文件 c3p0.config.xml 拷贝过来
    //该文件指定了 连接数据库和连接池的相关参数
    public void  testC3P0_02() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 使用配置文件 5000次连接mysql "+(end-start));
    }
}
