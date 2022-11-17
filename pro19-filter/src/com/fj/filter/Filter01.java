package com.fj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/2 12:27    since 1.0.0
 */
@WebFilter("*.do")
public class Filter01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("HELLO-A");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("HELLO-A2");
    }

    @Override
    public void destroy() {

    }
}
