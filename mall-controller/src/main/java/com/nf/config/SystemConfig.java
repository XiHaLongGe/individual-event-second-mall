package com.nf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

/**
 * @Author: LJP
 * @Classname SystemConfig
 * @Date: 2020-01-14 09:37
 * @Description: 继承AbstractAnnotationConfigDispatcherServletInitializer类
 *               来达到自动配置DispatcherServlet(前置控制器)和Spring应用上下文
 */
public class SystemConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 注册过滤器
     * @param servletContext
     * @param filter
     * @return
     */
    @Override
    protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
        return servletContext.addFilter("encoding" , new CharacterEncodingFilter("utf-8", true));
    }

    /**
     * 启用文件上传支持
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        /**
         * MultipartConfigElement类  构造函数参数如下
         * location参数设置要把这个上传上来的文件放在服务器的那个位置，这个位置是一个基础位置。
         * maxFileSize设置单个文件最大大小，  以k为单位  5242880 = 5M
         * maxRequestSize设置上传上来所有文件的总和大小限制。
         */
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }
}
