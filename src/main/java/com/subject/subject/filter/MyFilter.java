package com.subject.subject.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @title: MyFilter
 * @description:
 * @author: zhangfan
 * @data: 2018年05月26日 17:07
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {


    Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        logger.info("进入Filter");
        System.out.println("--------进入");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
