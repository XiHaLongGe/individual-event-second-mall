package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.ProductCategoryService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryController
 * @Date: 2020-01-29 09:50
 * @Description: 商品类型表
 */
@Controller
@RequestMapping("/mall/background/product/category")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品类型视图
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "background/product-category/homeCategoryList";
    }

    /**
     * 根据条件查询商品类型数据
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param productCategoryEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        ProductCategoryEntity productCategoryEntity){
        boolean result;
        //用户信息实体类型的列表对象
        List<ProductCategoryEntity> productCategoryEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的用户信息的相关数据
            productCategoryEntityList = productCategoryService.getPageByCondition(pageNum, pageSize, productCategoryEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(productCategoryEntityList, 5);
            result = true;
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(pageInfo)
                .build();

    }

}
