package com.aididi.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xuzexiang
 * @Date: 2018/7/9 0009
 * @Description:
 */
@Slf4j
public class InterceptorConfig implements HandlerInterceptor{
    /**
     * 功能描述:
     * @param: [request, response, handler]
     * @return: boolean
     * @auther: xuzexiang
     * @date: 2018/7/9 0009 下午 10:17
     * @Description: 进入controller层之前拦截请求
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("控制层请求之前调用");
           final String uri1 = "/user/login";
         final String uri2 = "/user/login_view";
        System.out.println(request.getRequestURI());
        //登录不做拦截
        if(uri1.equals(request.getRequestURI()) || uri2.equals(request.getRequestURI()))
        {
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");
        if(obj == null){
            response.sendRedirect("/user/login_view");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("控制层接到请求后，试图渲染之前调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("所有请求处理完后调用");
    }
}
