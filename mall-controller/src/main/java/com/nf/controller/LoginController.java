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
@RequestMapping("/mall/login")
public class LoginController {
    @Autowired
    private CustomerLoginService customerLoginService;

    /**
     * 登录视图
     * @return 登录视图名
     */
    @GetMapping("/home")
    public String home(){
        return "login/index";
    }

    /**
     * 注册成功视图
     * @return
     */
    @GetMapping("/success/register")
    public String successRegister(){
        return "login/successRegister";
    }

    /**
     * 进入管理员选择界面，进入前台或者是后台
     * @return 选择界面视图
     */
    @GetMapping("/master/option")
    public String masterOption(){
        return "login/masterOption";
    }

    /**
     * 对用户登录填入的帐号密码进行验证
     * @param customerLoginEntity 用来接收用户填入的账号密码
     * @return 以json数据格式响应ResponseVo对象给前台
     */
    @PostMapping("/verify")
    @ResponseBody
    public ResponseVo verify(@RequestBody CustomerLoginEntity customerLoginEntity, HttpServletRequest request){
        request.getSession(false);
        boolean result = customerLoginService.verifyLogin(customerLoginEntity);
        if(result) {setSessionData(customerLoginEntity.getLoginAccount(), request);}
        return ResponseVo.newBuilder()
                                    .code(result ? 200 : 500)
                                    .message(result ? "账号密码正确，验证通过" : "账号或密码输入错误，验证未通过")
                                    //获取到当前用户写入会话的身份信息
                                    .data(request.getSession().getAttribute("webmaster"))
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
        return ResponseVo.newBuilder()
                                    .code(result ? 200 : 500)
                                    .message(result ? "注册信息填写正确，注册成功" : "注册信息填写错误，注册失败")
                                    //这里将系统为用户生成的帐号响应回去
                                    .data(customerLoginEntity.getLoginAccount())
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
     * 用来清除会话信息，并重定向到登录界面
     * @param request 通过request请求对象来获取当前会话对象
     * @return
     */
    @PostMapping("/clear/session")
    @ResponseBody
    public ResponseVo clearSession(HttpServletRequest request){
        boolean result = true;
        try{
            //获取到当前会话
            HttpSession session = request.getSession(false);
            //清楚当前会话所有信息
            session.invalidate();
        }catch (Exception e){
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "会话信息成功清除！" : "会话信息清除失败！")
                //这里返回登录视图的访问地址
                .data("/mall/login/home")
                .build();
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
