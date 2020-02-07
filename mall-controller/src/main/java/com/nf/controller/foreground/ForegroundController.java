package com.nf.controller.foreground;

import com.nf.entity.CustomerLoginEntity;
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
 * @Classname ForegroundController
 * @Date: 2020-02-06 09:54
 * @Description: 前台主界面
 */
@Controller
@RequestMapping("/mall/foreground")
public class ForegroundController {
    @Autowired
    private CustomerLoginService customerLoginService;
    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Integer loginId = (Integer) session.getAttribute("loginId");
        CustomerLoginEntity customerLoginEntity = customerLoginService.getByLoginId(loginId);
        model.addAttribute("loginName", customerLoginEntity.getLoginName());
        return "foreground/home";
    }
}
