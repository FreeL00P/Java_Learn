package com.fj.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Copyright (C), 2017-2022 fj
 * <author>          <time>              <version>       <desc>
 * 冯俊        2022/6/22 13:53    since 1.0.0         inetAddress类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localhost=InetAddress.getLocalHost();
        System.out.println(localhost);

        //根据指定主机名 获取InetAddress对象
        InetAddress host1=InetAddress.getByName("XJUNJUN");
        System.out.println(host1);

        //根据域名返回
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //通过InetAddress对象 获取对应的地址
        String address = host2.getHostAddress();
        System.out.println(address);


    }
}
