package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.ProductCategoryService;
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
 * @Classname BrandInfController
 * @Date: 2020-01-31 18:34
 * @Description: 品牌信息表控制器
 */
@Controller
@RequestMapping("/mall/background/brand/inf")
public class BrandInfController {
    @Autowired
    private BrandInfService brandInfService;
    @Autowired
    private ProductCategoryService productCategoryService;
    /**
     * 品牌信息的视图
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "background/brand-inf/list";
    }


    /**
     * 根据条件查询品牌信息
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param brandInfEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        BrandInfEntity brandInfEntity){
        boolean result;
        //品牌信息实体类型的列表对象
        List<BrandInfEntity> brandInfEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的用户信息的相关数据
            brandInfEntityList = brandInfService.getPageByCondition(pageNum, pageSize, brandInfEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(brandInfEntityList, 5);
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
     * 根据类型层级来获取商品类型数据，因为品牌只需要2级层次所以这里写死
     * @return
     */
    @GetMapping("/product/category/data")
    @ResponseBody
    public ResponseVo productCategoryData(){
        boolean result = false;
        List<ProductCategoryEntity> categoryEntityList = null;
        try{
            categoryEntityList = productCategoryService.getByProductCategoryLevel(2);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(categoryEntityList)
                .build();
    }
}
