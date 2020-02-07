package com.nf.controller.foreground;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJP
 * @Classname ForegroundProductOrderController
 * @Date: 2020-02-07 22:58
 * @Description: 订单信息表控制器
 */
@Controller
@RequestMapping("/mall/foreground/product/order")
public class ForegroundProductOrderController {

    /**
     * 订单信息视图
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "foreground/product-order/submitOrder";
    }
}
