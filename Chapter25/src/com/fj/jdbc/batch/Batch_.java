package com.fj.jdbc.batch;

import com.fj.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/29 20:17    since 1.0.0
 * 演示java的批处理
 */
public class Batch_ {
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql="insert into admin2 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("[INFO] START RUN");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"jack"+i);
            preparedStatement.setString(2,"666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("RUN TIME "+(end-start));
        JDBCUtils.close(null,preparedStatement,connection);
    }

    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql="insert into admin3 values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("[INFO] BATCH START RUN");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1,"余达"+i+"号");
            preparedStatement.setString(2,"666");
            //将sql语句加入批处理包
            preparedStatement.addBatch();
            //当有一千条数据时 在批量执行
            if ((i+1)%1000==0){
                preparedStatement.executeBatch();
                //清空
                preparedStatement.clearBatch();
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("BATCH RUN TIME "+(end-start));
        JDBCUtils.close(null,preparedStatement,connection);
    }
}
