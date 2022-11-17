package com.fj.mhl.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/2 14:35    since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        int i = Utility.readInt();
        System.out.println(i);
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println(connection);


    }
}
