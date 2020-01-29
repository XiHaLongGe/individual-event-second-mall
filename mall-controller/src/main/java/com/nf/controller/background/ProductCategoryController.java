package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.ProductCategoryService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/add/product/category")
    public String addProductCategory(){return "background/product-category/add";}

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
        //品类型实体类型的列表对象
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

    /**
     * 根据商品类型层级来获取到商品类型信息
     * @param productCategoryLevel 用来接收商品类型层级
     * @return
     */
    @GetMapping("/level/data")
    @ResponseBody
    public ResponseVo levelData(Integer productCategoryLevel){
        boolean result = false;
        List<ProductCategoryEntity> productCategoryEntityList = null;
        try{
            productCategoryEntityList = productCategoryService.getByProductCategoryLevel(productCategoryLevel);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productCategoryEntityList)
                .build();
    }

    /**
     * 添加商品类型数据
     * @param productCategoryEntity 用来接收商品类型数据
     * @return
     */
    @PostMapping("/insert/product/category")
    @ResponseBody
    public ResponseVo insertProductCategory(ProductCategoryEntity productCategoryEntity){
        boolean result = productCategoryService.insertProductCategory(productCategoryEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "商品类型数据添加成功" : "商品类型数据添加失败")
                .data(result)
                .build();
    }
}
