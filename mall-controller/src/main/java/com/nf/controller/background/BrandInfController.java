package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProCategoryBrandInfRelevanceEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.PbrService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private PbrService pbrService;
    /**
     * 品牌信息的视图
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "background/brand-inf/brandInfList";
    }

    /**
     * 品牌信息的添加与修改视图
     * @param model 用来将数据写入请求域
     * @param brandInfId 需要修改的品牌id，修改时会用上
     * @return
     */
    @RequestMapping("/add/edit")
    public String addEdit(Model model, Integer brandInfId){
        String addOrEditType = "添加";
        if(brandInfId != null && brandInfId != 0){
            model.addAttribute("brandInfEntity", brandInfService.getByBrandInfId(brandInfId));
            addOrEditType = "修改";
        }
        model.addAttribute("addOrEditType", addOrEditType);
        return "background/brand-inf/brandInfAddEdit";
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
     * 添加品牌信息
     * @param brandInfEntity 用于接收添加信息
     * @return
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResponseVo insert(@RequestBody BrandInfEntity brandInfEntity){
        boolean result = brandInfService.insertBrandInf(brandInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据添加成功" : "数据添加失败")
                .data(result)
                .build();
    }

    /**
     * 修改品牌信息
     * @param brandInfEntity 用于接收修改信息
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public ResponseVo update(@RequestBody BrandInfEntity brandInfEntity){
        boolean result = brandInfService.updateBrandInf(brandInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据修改成功" : "数据修改失败")
                .data(result)
                .build();
    }


    /**
     * 批量删除品牌信息
     * @param brandInfIdArray 接收需要删除的品牌信息id
     * @return
     */
    @PostMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteBrandInf(@RequestBody Integer [] brandInfIdArray){
        boolean result = brandInfService.batchDeleteBrandInf(brandInfIdArray, true);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "删除品牌信息成功" : "删除品牌信息失败")
                .data(result)
                .build();
    }

}
