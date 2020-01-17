package com.nf.interceptor;

import com.nf.service.port.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: LJP
 * @Classname CustomerLoginInterceptor
 * @Date: 2020-01-17 14:07
 * @Description: 用户登录拦截器
 */
public class CustomerLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取到当前服务器会话
        HttpSession session = request.getSession();
        //获取到当前登录的用户昵称
        Object loginName = session.getAttribute("loginName");
        //昵称不会空(表示已登录)则放行
        if(loginName != null && !loginName.toString().isEmpty()){
            return true;
        }
        //未登录则转发到登录界面让未登录用户进行登录
        request.getRequestDispatcher("/mall/login").forward(request, response);
        return false;
    }
}
