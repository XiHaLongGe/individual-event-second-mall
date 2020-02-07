package com.nf.controller.background;

import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: LJP
 * @Classname BackgroundHomeController
 * @Date: 2020-01-19 10:06
 * @Description: 后台主界面
 */
@Controller
@RequestMapping("/mall/background")
public class BackgroundController {
    @Autowired
    private CustomerLoginService  customerLoginService;
    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer loginId = (Integer) session.getAttribute("loginId");
        CustomerLoginEntity customerLoginEntity = customerLoginService.getByLoginId(loginId);
        model.addAttribute("loginName", customerLoginEntity.getLoginName());
        return "background/home";
    }
}
