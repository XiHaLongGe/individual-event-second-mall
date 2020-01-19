package com.nf.config;

import com.nf.interceptor.CustomerLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: LJP
 * @Classname MvcConfig
 * @Date: 2020-01-13 21:59
 * @Description: 用来处理Spring MVC相关的配置类
 */
@Configuration
@ComponentScan("com.nf.controller")
@EnableWebMvc
@Import(AppConfig.class)
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 注册视图解析器，用来处理对视图的访问
     * @return 视图解析器实例
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
    }

    /**
     * 注册自定义拦截器
     * @param registry 拦截器列表对象
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  "/mall/foreground/**" 表示前台的所有资源
        //  "/mall/background/**" 表示后台的所有资源
        registry.addInterceptor(new CustomerLoginInterceptor()).addPathPatterns(
                                                                                    "/mall/foreground/**",
                                                                                    "/mall/background/**"
                                                                            );
    }

    /**
     * 注册处理静态资源的处理程序
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations(
                            "classpath:/static/login",
                            "classpath:/static/toolTip",
                            "classpath:/static/background/backend",
                            "classpath:/static/"
                );
    }

    /**
     * 注册自定义的Formatter和Convert
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        /*添加一个时间格式化器*/
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
