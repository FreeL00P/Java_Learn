package com.fj.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/20 14:31    since 1.0.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //创建properties类对象
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("D:\\Java\\Chapter19\\src\\mysql.properties"));
        //显示
        properties.list(System.out);
        //提供key获取信息
        String user=properties.getProperty("user");
        String pwd=properties.getProperty("pwd");
        System.out.println("用户名"+user+"密码"+pwd);
    }
}
