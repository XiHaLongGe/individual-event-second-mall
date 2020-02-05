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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     *
     * @return
     */
    @GetMapping("/home")
    public String home() {
        return "background/product-inf/list";
    }

    /**
     * 商品信息的添加与修改视图
     *
     * @param model        用来将数据写入请求域
     * @param productInfId 需要修改的商品id，修改时会用上
     * @return
     */
    @RequestMapping("/add/edit")
    public String addEdit(Model model, Integer productInfId) {
        String addOrEditType = "添加";
        if (productInfId != null && productInfId != 0) {
            model.addAttribute("productInfEntity", productInfService.getByProductInfId(productInfId));
            addOrEditType = "修改";
        }
        model.addAttribute("addOrEditType", addOrEditType);
        return "background/product-inf/addAndEdit";
    }

    /**
     * 商品图片修改视图
     * @param model 用来将数据写入请求域
     * @param productInfId 需要修改图片的商品id
     * @return
     */
    @RequestMapping("/edit/picture")
    public String editPicture(Model model, Integer productInfId){
        model.addAttribute("productInfId", productInfId);
        return "background/product-inf/editPicture";
    }

    /**
     * 根据条件查询商品信息
     *
     * @param pageNum          用来接收当前页数
     * @param pageSize         用来接收每页显示的条目
     * @param productInfEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        ProductInfEntity productInfEntity) {
        boolean result = true;
        //商品信息实体类型的列表对象
        List<ProductInfEntity> productInfEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try {
            //获取分页后的商品信息的相关数据
            productInfEntityList = productInfService.getPageByCondition(pageNum, pageSize, productInfEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(productInfEntityList, 5);
        } catch (Exception e) {
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
     *
     * @param childCategoryId 子类型id
     * @return
     */
    @GetMapping("/parent/category/data")
    @ResponseBody
    public ResponseVo parentCategoryData(String childCategoryId) {
        boolean result = true;
        ProductCategoryEntity productCategoryEntity = null;
        try {
            productCategoryEntity = productCategoryService.getByProductCategoryId(childCategoryId);
        } catch (Exception e) {
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
     *
     * @return
     */
    @GetMapping("/exist/brand/inf/data")
    @ResponseBody
    public ResponseVo existBrandInfData() {
        boolean result = true;
        List<BrandInfEntity> brandInfEntityList = null;
        try {
            //获取到关联表中所有的品牌信息id
            Integer[] brandInfIdArray = productInfService.getAllBrandInfId();
            brandInfEntityList = brandInfService.getExistData(brandInfIdArray);
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取商品信息表中的品牌信息成功" : "获取商品信息表中的品牌信息失败")
                .data(brandInfEntityList)
                .build();
    }


    /**
     * 添加商品信息
     *
     * @param productInfEntity 接受添加大的商品信息
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResponseVo insert(@RequestBody ProductInfEntity productInfEntity) {
        boolean result = productInfService.insertProductInf(productInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "添加商品信息成功" : "添加商品信息失败")
                .data(result)
                .build();
    }

    /**
     * 修改商品信息
     *
     * @param productInfEntity 接受修改大的商品信息
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseVo update(@RequestBody ProductInfEntity productInfEntity) {
        boolean result = productInfService.updateProductInf(productInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "修改商品信息成功" : "修改商品信息失败")
                .data(result)
                .build();
    }


    /**
     * 修改商品的轮播展示状态
     * @param productInfEntity 接受修改信息
     * @return
     */
    @PostMapping("/update/carousel")
    @ResponseBody
    public ResponseVo updateCarousel(@RequestBody ProductInfEntity productInfEntity){
        boolean result = productInfService.updateCarousel(productInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "修改商品轮播展示信息成功" : "修改商品轮播展示信息失败")
                .data(result)
                .build();
    }


    /**
     * 批量删除商品信息
     * @param productInfIdArray 接收需要删除的商品信息id
     * @return
     */
    @PostMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteBrandInf(@RequestBody Integer [] productInfIdArray){
        boolean result = productInfService.batchDeleteBrandInf(productInfIdArray);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "删除商品信息成功" : "删除商品信息失败")
                .data(result)
                .build();
    }
}
