package com.nf.controller.foreground;

import com.nf.entity.ProductInfEntity;
import com.nf.service.port.ProductInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * 商品信息视图
     * @param model 将数据存放至请求域
     * @param productInfId 商品信息id
     * @return
     */
    @GetMapping("/home")
    public String homeView(Model model, Integer productInfId){
        model.addAttribute("productInfId", productInfId);
        return "foreground/product-inf/productInf";
    }

    @GetMapping("/query/product")
    public String queryProductView(Model model, String productInfName){
        model.addAttribute("productInfName", productInfName);
        return "foreground/product-inf/queryProductInf";
    }


    /**
     * 根据商品id获得商品数据
     * @param productInfId 商品id
     * @return
     */
    @GetMapping("/single/data")
    @ResponseBody
    public ResponseVo productInfData(Integer productInfId){
        boolean result = true;
        ProductInfEntity productInfEntity = null;
        try{
            productInfEntity = productInfService.getByProductInfId(productInfId);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productInfEntity)
                .build();
    }


    /**
     * 根据商品名称及品牌信息、栏目信息来获得商品数据
     * @param productInfEntity 条件信息
     * @return
     */
    @GetMapping("/name/data")
    @ResponseBody
    public ResponseVo byProductNameData(ProductInfEntity productInfEntity){
        boolean result = true;
        List<ProductInfEntity> productInfEntities = null;
        try{
            productInfEntities = productInfService.getByProductName(productInfEntity);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productInfEntities)
                .build();
    }

    /**
     * 根据栏目id获取到相应数据
     * @param categoryId 用来接收栏目id
     * @return
     */
    @GetMapping("/column")
    @ResponseBody
    public ResponseVo columnData(String categoryId){
        boolean result = true;
        List<ProductInfEntity> productCategoryEntities = null;
        try{
            productCategoryEntities = productInfService.getByColumn(categoryId);
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
