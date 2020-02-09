package com.nf.controller.foreground;

import com.nf.entity.BrandInfEntity;
import com.nf.service.port.BrandInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ForegroundBrandInfController
 * @Date: 2020-02-09 11:11
 * @Description:
 */
@Controller
@RequestMapping("/mall/foreground/brand/inf")
public class ForegroundBrandInfController {
    @Autowired
    private BrandInfService brandInfService;

    /**
     * 根据商品名称获取相对应的品牌信息
     * @param productInfName 商品名称
     * @return
     */
    @GetMapping("/belong")
    @ResponseBody
    public ResponseVo belongByProductInfName(String productInfName){
        boolean result = true;
        List<BrandInfEntity> brandInfEntityList = null;
        try{
            brandInfEntityList = brandInfService.getBelongByProductInfName(productInfName);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(brandInfEntityList)
                .build();
    }
}
