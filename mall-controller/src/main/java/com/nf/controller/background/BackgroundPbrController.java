package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProCategoryBrandInfRelevanceEntity;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.PbrService;
import com.nf.service.port.ProductCategoryService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PbrController
 * @Date: 2020-02-03 16:10
 * @Description: 商品类型与品牌信息的关联表控制器
 */
@Controller
@RequestMapping("/mall/background/pbr")
public class BackgroundPbrController {
    @Autowired
    private PbrService pbrService;
    @Autowired
    private BrandInfService brandInfService;
    @Autowired
    private ProductCategoryService productCategoryService;


    /**
     * 关联表信息的视图
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "background/brand-inf/pbrList";
    }


    /**
     * 关联表添加和修改的视图
     * @param model 用来将数据写入请求域
     * @param pbrId 用来接收关联表id
     * @return
     */
    @RequestMapping("/add/edit")
    public String addEdit(Model model, Integer pbrId){
        String addOrEditType = "添加";
        if(pbrId != null && pbrId != 0){
            model.addAttribute("pbrEntity", pbrService.getByPbrId(pbrId));
            addOrEditType = "修改";
        }
        model.addAttribute("addOrEditType", addOrEditType);
        return "background/brand-inf/pbrAddEdit";
    }



    /**
     * 根据条件查询关联表信息
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param pbrEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        ProCategoryBrandInfRelevanceEntity pbrEntity){
        boolean result = true;
        List<ProCategoryBrandInfRelevanceEntity> pbrEntityList;
        PageInfo pageInfo = null;
        try{
            pbrEntityList = pbrService.getPageByCondition(pageNum, pageSize, pbrEntity);
            pageInfo = new PageInfo(pbrEntityList, 5);
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
     * 获取存在关联表中的品牌信息
     * @return
     */
    @GetMapping("/exist/brand/inf/data")
    @ResponseBody
    public ResponseVo existBrandInfData(){
        boolean result = true;
        List<BrandInfEntity> brandInfEntityList = null;
        try {
            //获取到关联表中所有的品牌信息id
            Integer[] brandInfIdArray = pbrService.getAllBrandInfId();
            brandInfEntityList = brandInfService.getExistData(brandInfIdArray);
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取关联表中的品牌信息成功" : "获取关联表中的品牌信息失败")
                .data(brandInfEntityList)
                .build();
    }

    /**
     * 获取存在关联表中的商品类型信息
     * @return
     */
    @GetMapping("/exist/pro/category/data")
    @ResponseBody
    public ResponseVo existProCategoryData(){
        boolean result = true;
        List<ProductCategoryEntity> proCategoryEntityList = null;
        try {
            proCategoryEntityList = productCategoryService.getExistPbrData();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "获取关联表中的商品类型成功" : "获取关联表中的商品类型失败")
                .data(proCategoryEntityList)
                .build();
    }


    /**
     * 添加关联表数据
     * @param pbrEntity 用于接收关联表数据
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResponseVo insert(@RequestBody ProCategoryBrandInfRelevanceEntity pbrEntity){
        boolean result = pbrService.insertPbr(pbrEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据添加成功" : "数据添加失败")
                .data(result)
                .build();
    }

    /**
     * 修改品牌信息
     * @param pbrEntity 用于接收修改信息
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseVo update(@RequestBody ProCategoryBrandInfRelevanceEntity pbrEntity){
        boolean result = pbrService.updatePbr(pbrEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据修改成功" : "数据修改失败")
                .data(result)
                .build();
    }


    /**
     * 批量删除关联表数据
     * @param pbrIdArray 接收需要删除的关联表id
     * @return
     */
    @PostMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeletePbr(@RequestBody Integer [] pbrIdArray){
        boolean result = pbrService.batchDeletePbr(pbrIdArray);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "删除关联表信息成功" : "删除关联表信息失败")
                .data(result)
                .build();
    }


}
