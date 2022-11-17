package com.fj.jdbc;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/28 14:10    since 1.0.0
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //1 注册驱动
        //创建driver对象
        Driver driver = new Driver();
        //连接到数据库的地址
        String url="jdbc:mysql://localhost:3306/jdbcDB";
        //将用用户名和密码放入到Properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        //2 得到连接
        Connection connect = driver.connect(url, properties);
        //3 执行sql
       // String sql="insert into actor values(null,'余发','男','1970-11-11','110')";
        String sql="update actor set name='蔡徐坤' where id=1";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//rows表示受影响的行数
        System.out.println(rows>0?"成功":"失败");
        //4 关闭连接资源
        statement.close();
        connect.close();
    }
}
