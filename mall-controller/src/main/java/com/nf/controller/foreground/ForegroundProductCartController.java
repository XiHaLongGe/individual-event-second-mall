package com.nf.controller.foreground;

import com.nf.entity.ProductCartEntity;
import com.nf.service.port.ProductCartService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ForegroundProductCartController
 * @Date: 2020-02-07 12:01
 * @Description: 购物车控制器
 */
@Controller
@RequestMapping("/mall/foreground/product/cart")
public class ForegroundProductCartController {
    @Autowired
    private ProductCartService productCartService;

    /**
     * 获得传入用户登录id的购物车中的商品数量
     * @param loginId 用户登录id
     * @return
     */
    @GetMapping("/data/count")
    @ResponseBody
    public ResponseVo dataCount(Integer loginId){
        boolean result = true;
        Integer count = 0;
        try{
            count = productCartService.getCountByLoginId(loginId);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(count)
                .build();
    }

    /**
     * 添加商品到购物车
     * @param productCartEntity 购物车信息
     * @return
     */
    @PostMapping("/add/cart")
    @ResponseBody
    public ResponseVo addCart(@RequestBody ProductCartEntity productCartEntity){
        boolean result = productCartService.addCart(productCartEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "添加成功" : "添加失败")
                .data(result)
                .build();
    }
}
