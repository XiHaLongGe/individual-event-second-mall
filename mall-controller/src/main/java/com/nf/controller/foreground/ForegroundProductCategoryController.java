package com.nf.controller.foreground;

import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.ProductCategoryService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ForegroundProductCategoryController
 * @Date: 2020-02-07 09:24
 * @Description: 商品分类信息控制器
 */

@Controller
@RequestMapping("/mall/foreground/product/category")
public class ForegroundProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 根据商品层次来获得商品类型数据
     * @param productCategoryLevel 用来接收商品类型层次
     * @return
     */
    @GetMapping("/level/data")
    @ResponseBody
    public ResponseVo getDataByLevel(Integer productCategoryLevel){
        boolean result = false;
        List<ProductCategoryEntity> productCategoryEntities = null;
        try{
            productCategoryEntities = productCategoryService.getByProductCategoryLevel(productCategoryLevel);
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


    /**
     * 根据父类型id获得商品类型数据
     * @param parentCategoryId 用来接收父类型id
     * @return
     */
    @GetMapping("/parent/data")
    @ResponseBody
    public ResponseVo getDataByParentId(String parentCategoryId){
        boolean result = false;
        List<ProductCategoryEntity> productCategoryEntities = null;
        try{
            productCategoryEntities = productCategoryService.getByParentCategoryId(parentCategoryId);
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
