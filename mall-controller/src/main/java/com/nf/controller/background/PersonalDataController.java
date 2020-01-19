package com.nf.controller.background;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJP
 * @Classname PersonalDataController
 * @Date: 2020-01-19 15:55
 * @Description: 后台：用户个人资料的控制器
 */
@Controller
@RequestMapping("/mall/background")
public class PersonalDataController {
    @GetMapping("/personal/data")
    public String personalData(){
        return "background/personalData";
    }
}
