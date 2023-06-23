package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "myFilter2", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
@Order(20)
public class MyFilter200 implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        logger.info("2222222222222222, com.example.demo.filter.MyFilter2 preprocessing before moving forward, get remoteHost = {}", servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("2222222222222222, com.example.demo.filter.MyFilter2 postprocessing before return back to caller, get remoteHost = {}", servletResponse.getContentType());

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
