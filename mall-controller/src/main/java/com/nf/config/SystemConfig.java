package com.nf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * @Author: LJP
 * @Classname SystemConfig
 * @Date: 2020-01-14 09:37
 * @Description: 继承AbstractAnnotationConfigDispatcherServletInitializer类
 *               来达到自动配置DispatcherServlet(前置控制器)和Spring应用上下文
 */
@Configuration
public class SystemConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
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
}
