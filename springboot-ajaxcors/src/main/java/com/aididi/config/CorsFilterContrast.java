package com.aididi.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xuzexiang
 * @Date: 2018-9-12 0012
 * @Description:    自定义过滤器实现跨域请求
 */
@Log4j2
@Component
public class CorsFilterContrast implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        rep.setHeader("Access-Control-Allow-Origin",req.getHeader("Origin"));
        rep.setHeader("Access-Control-Allow-Methods","POST,GET,DELETE,PUT,OPTIONS");
        rep.setHeader("Access-Control-Max-Age","3600");
        rep.setHeader("Access-Control-Allow-Headers","x-requested-with");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("过滤器销毁");
    }
}
