package com.fj.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/1 13:34    since 1.0.0
 */
@WebServlet(urlPatterns = {"/demo01"},initParams = {
        @WebInitParam(name = "hello",value = "world")
})
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String hello = config.getInitParameter("hello");
        System.out.println("hello = " + hello);
        ServletContext servletContext = getServletContext();
        String contestConfigLocation = servletContext.getInitParameter("contestConfigLocation");
        System.out.println("contestConfigLocation = " + contestConfigLocation);

    }
}
