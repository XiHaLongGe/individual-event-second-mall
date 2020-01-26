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
     * 添加用户视图
     * @return
     */
    @GetMapping("/add/customer")
    public String addCustomer(){return "background/customer-login/add";}

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
            e.printStackTrace();
        }
        return ResponseVo.newBuilder()
                    .code(result ? 200 : 500)
                    .message(result ? "数据获取成功" : "数据获取失败")
                    .data(pageInfo)
                .build();
    }

    /**
     * 根据条件查询用户登录信息数据
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param customerLoginEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
            CustomerLoginEntity customerLoginEntity
    ){
        boolean result;
        //用户登录类型的列表对象
        List<CustomerLoginEntity> customerLoginEntityList;
        //分页工具类对象
        PageInfo pageInfo = null;
        try{
            //获取分页后的用户登录信息的相关数据
            customerLoginEntityList = customerLoginService.getPageByCondition(pageNum, pageSize, customerLoginEntity);
            //使用分页工具类对象来处理数据的分页效果
            pageInfo = new PageInfo(customerLoginEntityList, 5);
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
     * 后台：添加用户
     * @param customerLoginEntity 用于接收添加用户的信息
     * @return
     */
    @PostMapping("/insert/customer")
    @ResponseBody
    public ResponseVo insertCustomer(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.registerCustomer(customerLoginEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "用户添加成功" : "用户添加失败")
                .data(customerLoginEntity.getLoginAccount())
                .build();
    }

    /**
     * 更新用户账号状态
     * @param customerLoginEntity
     * @return
     */
    @PostMapping("/update/state")
    @ResponseBody
    public ResponseVo updateState(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.updateAccountStats(customerLoginEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "账号状态更新成功" : "账号状态更新失败")
                .data(result)
                .build();
    }

    /**
     * 重置用户密码
     * @param customerLoginEntity 接收需要重置密码的用户id
     * @return
     */
    @PostMapping("/reset/password")
    @ResponseBody
    public ResponseVo resetPassword(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.resetPassword(customerLoginEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "密码重置成功" : "密码重置失败")
                .data(result)
                .build();
    }

    /**
     * 删除用户
     * @param customerLoginEntity 接收需要删除的用户id
     * @return
     */
    @PostMapping("/delete/customer")
    @ResponseBody
    public ResponseVo deleteCustomer(@RequestBody CustomerLoginEntity customerLoginEntity){
        boolean result = customerLoginService.deleteCustomer(customerLoginEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "删除用户成功" : "删除用户失败")
                .data(result)
                .build();
    }
}
