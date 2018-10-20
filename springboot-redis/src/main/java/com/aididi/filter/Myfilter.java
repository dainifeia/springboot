package com.aididi.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xuzexiang
 * @Date: 2018/7/25 0025
 * @Description:
 */
@Slf4j
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("" + getClass() + " init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest srequest = (HttpServletRequest) request;
        System.out.println("this is MyFilter,url :"+srequest.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("" + getClass() + " destroy");
    }
}
