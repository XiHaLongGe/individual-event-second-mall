package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProductCategoryEntity;
import com.nf.entity.ProductInfEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.ProductCategoryService;
import com.nf.service.port.ProductInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfController
 * @Date: 2020-02-02 14:24
 * @Description: 商品信息控制器
 */
@Controller
@RequestMapping("/mall/background/product/inf")
public class ProductInfController {

    @Autowired
    private ProductInfService productInfService;
    @Autowired
    private BrandInfService brandInfService;
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 商品信息视图
     * @return
     */
    @GetMapping("/home")
    public String home(){return "background/product-inf/list";}

    /**
     * 根据条件查询商品信息
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param productInfEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        ProductInfEntity productInfEntity){
        boolean result =true;
        //商品信息实体类型的列表对象
        List<ProductInfEntity> productInfEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的商品信息的相关数据
            productInfEntityList = productInfService.getPageByCondition(pageNum, pageSize, productInfEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(productInfEntityList, 5);
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
     * 获取到传来的商品类型id的父类型
     * @param childCategoryId 子类型id
     * @return
     */
    @GetMapping("/parent/category/data")
    @ResponseBody
    public ResponseVo parentCategoryData(String childCategoryId){
        boolean result = true;
        ProductCategoryEntity productCategoryEntity = null;
        try {
            productCategoryEntity = productCategoryService.getByProductCategoryId(childCategoryId);
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取商品信息表父类型信息成功" : "获取商品信息表父类型信息失败")
                .data(productCategoryEntity)
                .build();
    }

    /**
     * 获取存在商品信息表中的品牌信息
     * @return
     */
    @GetMapping("/exist/brand/inf/data")
    @ResponseBody
    public ResponseVo existBrandInfData(){
        boolean result = true;
        List<BrandInfEntity> brandInfEntityList = null;
        try {
            //获取到关联表中所有的品牌信息id
            Integer[] brandInfIdArray = productInfService.getAllBrandInfId();
            brandInfEntityList = brandInfService.getExistData(brandInfIdArray);
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取商品信息表中的品牌信息成功" : "获取商品信息表中的品牌信息失败")
                .data(brandInfEntityList)
                .build();
    }
}
