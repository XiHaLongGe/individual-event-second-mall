package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerLoginController
 * @Date: 2020-01-25 20:37
 * @Description: 后台：登录信息控制器
 */
@Controller
@RequestMapping("/mall/background/customer/login")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;

    /**
     * 后台：用户登录信息视图
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "background/customer-login/list";
    }

    /**
     * 获取到分页后用户登录信息的相关数据
     * @param pageNum 当前页数
     * @param pageSize 每页显示数据条目
     * @return
     */
    @GetMapping("/page/data")
    @ResponseBody
    public ResponseVo pageData(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize
    ){
        boolean result;
        //用户登录类型的列表对象
        List<CustomerLoginEntity> customerLoginEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的用户登录信息的相关数据
            customerLoginEntityList = customerLoginService.getPageAll(pageNum, pageSize);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(customerLoginEntityList, 5);
            result = true;
        }catch (Exception e){
            result = false;
        }
        return ResponseVo.newBuilder()
                    .code(result ? 200 : 500)
                    .message(result ? "数据获取成功" : "数据获取失败")
                    .data(pageInfo)
                .build();
    }
}
