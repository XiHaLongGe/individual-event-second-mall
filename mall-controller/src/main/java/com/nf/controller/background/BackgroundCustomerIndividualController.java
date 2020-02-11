package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.service.port.CustomerIndividualService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerIndividualController
 * @Date: 2020-01-28 06:42
 * @Description: 后台： 用户信息表控制器
 */
@Controller
@RequestMapping("/mall/background/customer/individual")
public class BackgroundCustomerIndividualController {
    @Autowired
    private CustomerIndividualService customerIndividualService;

    /**
     * 用户信息视图
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "background/customer-individual/list";
    }

    /**
     * 根据条件查询用户信息数据
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param customerIndividualEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                               CustomerIndividualEntity customerIndividualEntity){

        boolean result;
        //用户信息实体类型的列表对象
        List<CustomerIndividualEntity> customerIndividualEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的用户信息的相关数据
            customerIndividualEntityList = customerIndividualService.getPageByCondition(pageNum, pageSize, customerIndividualEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(customerIndividualEntityList, 5);
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
     * 批量删除用户
     * @param loginIdArray 接收需要删除的用户id
     * @return
     */
    @PostMapping("/batch/delete/customer")
    @ResponseBody
    public ResponseVo batchDeleteCustomer(@RequestBody String [] loginIdArray){
        boolean result = customerIndividualService.batchDeleteCustomer(loginIdArray, true);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "删除用户成功" : "删除用户失败")
                .data(result)
                .build();
    }
}
