package com.fj.jdbc.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/6/30 21:59    since 1.0.0
 * 播放量
 */
public class DBUtils_use {
    //使用Apache DBUtils 工具类+druid 完成对表的crud
    @Test
    public void testQueryMany() throws SQLException {//返回结果是多行的情况
        //得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用BDUtils的类和接口
        //创建一个queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //执行相关方法 返回一个ArrayList
        String sql="select * from 2021_10月b站热播视频排行数据;";
        //query方法就是执行sql 语句 得到ResultSet 封装到 arraylist集合
        //返回一个集合
        //sql 执行的sql语句
        // new BeanListHandler<>(Bilibili.class) 在将resultSet-->Bilibili对象 -->封装到ArrayList
        //底层使用反射机制 去获取Bilibili类的属性进行封装
        // 1是给sql中的?进行赋值
        // 底层得到的resultset方法会在query关闭 关闭PreparedStatement
        List<Bilibili> query = queryRunner.query(connection, sql, new BeanListHandler<>(Bilibili.class)/*1*/);
        for (Bilibili bilibili :query) {
            System.out.println(bilibili);
        }
        JDBCUtilsByDruid.close(null,null,connection);
    }
    //演示Apache-dbutils+druid完成返回的结果是单行记录
    @Test
    public void testQuerySinge() throws SQLException {//返回结果是多行的情况
        //得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用BDUtils的类和接口
        //创建一个queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //执行相关方法 返回一个ArrayList
        String sql = "select * from 2021_10月b站热播视频排行数据 limit 1;";
        //单行记录 所以用BeanHandler
        Bilibili bilibili = queryRunner.query(connection, sql, new BeanHandler<>(Bilibili.class));
        System.out.println(bilibili);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }

    //演示Apache-dbutils+druid完成返回的结果是单行记录
    @Test
    public void testScalar() throws SQLException {//返回结果是多行的情况
        //得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用BDUtils的类和接口
        //创建一个queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //执行相关方法 返回一个ArrayList
        String sql = "select title from 2021_10月b站热播视频排行数据 limit 1;";
        //单行单列 因为 返回的是object对象 使用的handler 为ScalarHandler
        Object bilibili = queryRunner.query(connection, sql, new ScalarHandler());
        System.out.println(bilibili);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
    @Test
    public void testDML() throws SQLException {
//得到一个连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //使用BDUtils的类和接口
        //创建一个queryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //执行相关方法 返回受影响的行数
        String sql = "update insert delete;";
        int rows = queryRunner.update(connection, sql, new ScalarHandler());
        System.out.println(rows);
        //释放资源
        JDBCUtilsByDruid.close(null,null,connection);
    }
}
