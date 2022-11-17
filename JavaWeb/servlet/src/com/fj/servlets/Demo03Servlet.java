package com.fj.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/7/29 9:34    since 1.0.0
 */
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)  {
        //获取session 如果获取不到则创建一个新的
        HttpSession session=req.getSession();
        System.out.println("session ID:"+session.getId());
        session.getMaxInactiveInterval();//最大最大非激活间隔时长 默认1800秒
    }
}
