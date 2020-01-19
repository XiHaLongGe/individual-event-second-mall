package com.nf.controller.background;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJP
 * @Classname BackgroundHomeController
 * @Date: 2020-01-19 10:06
 * @Description: 后台主界面
 */
@Controller
@RequestMapping("/mall/background")
public class BackgroundHomeController {

    @GetMapping("/home")
    public String home(){
        return "background/home";
    }
}
