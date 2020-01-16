package com.nf.controller;


import com.nf.entity.CustomerLoginEntity;
import com.nf.service.impl.CustomerLoginServiceImpl;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * 打开登录视图
     * @return
     */
    @GetMapping("/login")
    public String login(){
        return "login/index";
    }

    @PostMapping("/verify")
    @ResponseBody
    public ResponseVo verify(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.verifyLogin(customerLoginEntity);
        Integer code = result ? 200 : 500;
        String message = result ? "账号密码正确，验证通过" : "账号或密码输入错误，验证未通过";
        return ResponseVo.newBuilder().code(code).message(message).data(result).build();
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseVo register(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.registerCustomer(customerLoginEntity);
        Integer code = result ? 200 : 500;
        String message = result ? "注册信息填写正确，注册成功" : "注册信息填写错误，注册失败";
        return ResponseVo.newBuilder().code(code).message(message).data(result).build();
    }

}
