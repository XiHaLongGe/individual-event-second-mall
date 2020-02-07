package com.nf.controller.foreground;

import com.nf.entity.ProductInfEntity;
import com.nf.service.port.ProductInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Author: LJP
 * @Classname ForegroundProductInfController
 * @Date: 2020-02-07 09:49
 * @Description: 前台 商品信息控制器
 */
@Controller
@RequestMapping("/mall/foreground/product/inf")
public class ForegroundProductInfController {
    @Autowired
    private ProductInfService productInfService;


    /**
     * 根据栏目id获取到相应数据
     * @param categoryId 用来接收栏目id
     * @return
     */
    @GetMapping("/column")
    @ResponseBody
    public ResponseVo columnData(String categoryId){
        boolean result = false;
        List<ProductInfEntity> productCategoryEntities = null;
        try{
            productCategoryEntities = productInfService.getByColumn(categoryId);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productCategoryEntities)
                .build();
    }

}
