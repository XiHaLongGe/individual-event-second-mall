package com.nf.controller;


import com.nf.service.impl.CustomerLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJP
 * @Classname CustomerLoginController
 * @Date: 2020-01-13 22:02
 * @Description: 用户登录的控制器
 */
@Controller
@RequestMapping("/mall")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginServiceImpl customerLoginService;

    /**
     * 打开登录视图的控制器方法
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login/index";
    }

}
