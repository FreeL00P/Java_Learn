package com.fj.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/29 13:00    since 1.0.0
 */
public class JDBCUtils_Use {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        String sql="select * from 2021_7月b站热播视频排行数据 where 排名=?";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,23);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){//让光标向下移动 如果没有更多行 返回false
                String title =         resultSet.getString(1);//获取该行的第一列
                String link =   resultSet.getString(2);//获取改行第二列
                String UP =  resultSet.getString(3);
                String commit=  resultSet.getString(4);
                String num= resultSet.getString(5);
                int id = resultSet.getInt(6);
                //System.out.println("视频标题 "+title+" 视频链接 "+link+" UP "+UP+" 评论数 "+commit+" 播放量 "+num+" 排行 "+id);
                System.out.println((title+"\t"+link+"\t"+UP+"\t"+commit+"\t"+num+"\t"+id).replace("\n",""));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
    }


}
