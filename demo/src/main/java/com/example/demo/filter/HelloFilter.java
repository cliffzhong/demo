package com.example.demo.filter;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "helloFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
@Order(30)
public class HelloFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("================, com.example.demo.filter.HelloFilter preprocessing before moving forward, get remoteHost = {}", servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("================, com.example.demo.filter.HelloFilter postprocessing before return back to caller, get remoteHost = {}", servletResponse.getContentType());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
