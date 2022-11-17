package com.fj.jdbc.preparedstatement;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/28 22:22    since 1.0.0
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws SQLException {
        //使用反射加载Driver类 使用Class.forName自动完成注册驱动
        //在加载Driver时完成注册
        //Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jundb";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        //2 得到连接
        Connection connection = DriverManager.getConnection(url, properties);
        //?相对于 占位符
        String sql="select * from 2021_7月b站热播视频排行数据 where 排名=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner=new Scanner(System.in);
        int i = scanner.nextInt();
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        //使用while循环取出数据
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
    }
}
