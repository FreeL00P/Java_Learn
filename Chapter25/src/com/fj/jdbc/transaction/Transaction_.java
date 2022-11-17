package com.fj.jdbc.transaction;

import com.fj.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/29 19:53    since 1.0.0
 * 演示jdbc中如何使用事务
 */
public class Transaction_ {
    @Test
    public void noTransaction(){
        //操作转账业务
        Connection connection = JDBCUtils.getConnection();
        String sql="update account set balance=balance-100 where id=1";
        String sql2="update account set balance=balance+100 where id=2";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            int i=1/0;
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
    @Test
    public void useTransaction(){
        //操作转账业务
        Connection connection=null;
        String sql="update account set balance=balance-100 where id=1";
        String sql2="update account set balance=balance+100 where id=2";
        PreparedStatement preparedStatement=null;
        try {
            connection= JDBCUtils.getConnection();
            connection.setAutoCommit(false);//开启了事务
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            //int i=1/0;
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);

        }finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
