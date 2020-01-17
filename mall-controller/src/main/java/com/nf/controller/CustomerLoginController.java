package com.nf.controller;


import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    private CustomerLoginService customerLoginService;

    /**
     * 打开登录视图
     * @return 登录视图名
     */
    @GetMapping("/login")
    public String login(){
        return "login/index";
    }

    /**
     * 对用户登录填入的帐号密码进行验证
     * @param customerLoginEntity 用来接收用户填入的账号密码
     * @return 以json数据格式响应ResponseVo对象给前台
     */
    @PostMapping("/verify")
    @ResponseBody
    public ResponseVo verify(@RequestBody CustomerLoginEntity customerLoginEntity, HttpServletRequest request){
        boolean result = customerLoginService.verifyLogin(customerLoginEntity);
        if(result) {setSessionData(customerLoginEntity.getLoginAccount(), request);}
        Integer code = result ? 200 : 500;
        String message = result ? "账号密码正确，验证通过" : "账号或密码输入错误，验证未通过";
        return ResponseVo.newBuilder()
                                    .code(code)
                                    .message(message)
                                    .data(result)
                                .build();
    }

    /**
     * 处理用户的注册操作
     * @param customerLoginEntity 用来接收用户填入的信息
     * @return 以json数据格式响应ResponseVo对象给前台
     */
    @PostMapping("/register")
    @ResponseBody
    public ResponseVo register(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.registerCustomer(customerLoginEntity);
        Integer code = result ? 200 : 500;
        String message = result ? "注册信息填写正确，注册成功" : "注册信息填写错误，注册失败";
        return ResponseVo.newBuilder()
                                    .code(code)
                                    .message(message)
                                    .data(result)
                                .build();
    }

    /**
     * 处理用户激活帐号的操作
     * @param activateCode 激活码
     * @param model 用来将激活结果写入请求作用域
     * @return 激活结果的视图名
     */
    @GetMapping("/activate")
    public String activate(String activateCode, Model model){
        //创建一个CustomerLoginEntity实例，将激活码及帐号状态写入    帐号状态: 0 表示未激活，1 表示激活
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder()
                                                                                .activateCode(activateCode)
                                                                                .accountStats(Byte.valueOf("1"))
                                                                            .build();
        //下面这部操作将激活结果写入请求作用域，给予前台告知用户激活结果
        model.addAttribute("activate", customerLoginService.updateAccountStats(customerLoginEntity));
        return "login/activate";
    }

    /**
     * 将用户的登录数据写进会话中
     * @param loginAccount 用户登录帐号
     */
    private void setSessionData(String loginAccount, HttpServletRequest request){
        HttpSession session = request.getSession();
        //根据用户登录帐号获取到用户的登录表信息
        CustomerLoginEntity customerLoginEntity = customerLoginService.getByLoginAccount(loginAccount);
        //将用户登录id写入会话中
        session.setAttribute("loginId", customerLoginEntity.getLoginId());
        //将用户昵称写入会话中
        session.setAttribute("loginName", customerLoginEntity.getLoginName());
        //将用户身份,是否为管理员
        session.setAttribute("webmaster", customerLoginEntity.getWebmaster());
    }
}
