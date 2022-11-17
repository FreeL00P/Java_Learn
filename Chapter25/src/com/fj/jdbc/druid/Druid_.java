package com.fj.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/6/30 16:01    since 1.0.0
 * 使用德鲁伊
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        //创建一个properties对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\Java\\Chapter25\\src\\druid.properties"));
        //创建一个指定参数的数据库连接池
        //通过文件指定
        //返回一个数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("C3P0 使用配置文件 5000次连接mysql "+(end-start));
        System.out.println("连接成功");

    }
}
