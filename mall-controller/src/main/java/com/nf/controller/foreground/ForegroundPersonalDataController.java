package com.nf.controller.foreground;

import com.nf.service.port.CustomerIndividualService;
import com.nf.service.port.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: LJP
 * @Classname ForegroundPersonalDataController
 * @Date: 2020-02-06 10:55
 * @Description: 前台个人信息控制器
 */
@Controller
@RequestMapping("/mall/foreground/personal")
public class ForegroundPersonalDataController {
    @Autowired
    private CustomerLoginService customerLoginService;
    @Autowired
    private CustomerIndividualService customerIndividualService;

    /**
     * 个人资料视图
     * @param model 通过该对象将个人资料信息存放至请求域中
     * @param request 通过当前请求对象来获得会话对象，用来获取当前登录用户信息
     * @return
     */
    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取用户登录id
        Integer loginId = (Integer) session.getAttribute("loginId");
        //根据用户登录id查出用户登录表数据，并存放至请求域
        model.addAttribute("customerLoginEntity", customerLoginService.getByLoginId(loginId));
        return "foreground/personal/list";
    }
    /**
     * 个人信息视图
     * @param model 通过该对象将个人资料信息存放至请求域中
     * @param request 通过当前请求对象来获得会话对象，用来获取当前登录用户信息
     * @return
     */
    @GetMapping("/information/home")
    public String personInformation(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        //获取用户登录id
        Integer loginId = (Integer) session.getAttribute("loginId");
        //根据用户登录id查出用户登录表数据，并存放至请求域
        model.addAttribute("customerLoginEntity", customerLoginService.getByLoginId(loginId));
        //根据用户登录id查出用户信息表数据，并存放至请求域
        model.addAttribute("customerIndividualEntity", customerIndividualService.getByLoginId(loginId));
        return "foreground/personal/personInformation";
    }
}
