package com.nf.interceptor;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: LJP
 * @Classname EncodingInterceptor
 * @Date: 2020-01-22 08:02
 * @Description: 字符编码过滤器
 */
// extends CharacterEncodingFilter
public class EncodingInterceptor implements HandlerInterceptor {
    /**
     * ENCODING: 字符编码
     */
    private static final String ENCODING = "UTF-8";
    /**
     * requestURIArray: 存放白名单的URI
     */
    private static final String [] requestURIArray = {};

    /*public EncodingInterceptor(String encoding, boolean forceEncoding) {
        super(encoding, forceEncoding);
    }*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        for (String s : requestURIArray) {
            if(requestURIArray.length != 0){
                //这里就是判断请求URI是否属于白名单
                if(requestURI.equals(s)){
                    return true;
                }
            }else{
                break;
            }
        }
        request.setCharacterEncoding(ENCODING);
//        response.setContentType("text/html;charset=" + ENCODING);
        return true;
    }
}
