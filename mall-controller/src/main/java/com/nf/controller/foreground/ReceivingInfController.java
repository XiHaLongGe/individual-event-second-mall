package com.nf.controller.foreground;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductCategoryEntity;
import com.nf.entity.ReceivingInfEntity;
import com.nf.service.port.ReceivingInfService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfController
 * @Date: 2020-02-06 11:40
 * @Description: 收货信息控制器
 */
@Controller
@RequestMapping("/mall/foreground/receiving")
public class ReceivingInfController {
    @Autowired
    private ReceivingInfService receivingInfService;

    /**
     * 收货信息视图
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "foreground/personal/receiving";
    }

    /**
     * 根据用户id获取所有收货信息
     * @param loginId 用户id
     * @return
     */
    @GetMapping("/customer/data")
    @ResponseBody
    public ResponseVo customerData(Integer loginId){
        boolean result = false;
        List<ReceivingInfEntity> receivingInfEntities = null;
        try{
            receivingInfEntities = receivingInfService.getListByLoginId(loginId);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(receivingInfEntities)
                .build();
    }

    /**
     * 根据收货信息id获取所有收货信息
     * @param receivingInfId 收货信息id
     * @return
     */
    @GetMapping("/receiving/data")
    @ResponseBody
    public ResponseVo receivingData(Integer receivingInfId){
        boolean result = false;
        ReceivingInfEntity receivingInfEntities = null;
        try{
            receivingInfEntities = receivingInfService.getListByReceivingInfId(receivingInfId);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(receivingInfEntities)
                .build();
    }


    /**
     * 添加收货信息
     * @param receivingInfEntity 接收要添加的信息
     * @return
     */
    @PostMapping("/insert/receiving")
    @ResponseBody
    public ResponseVo insertReceiving(@RequestBody ReceivingInfEntity receivingInfEntity){
        boolean result = receivingInfService.insertReceivingInf(receivingInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "收货信息添加成功" : "收货信息添加失败")
                .data(result)
                .build();
    }

    /**
     * 修改收货信息
     * @param receivingInfEntity 接收要修改的信息
     * @return
     */
    @PostMapping("/update/receiving")
    @ResponseBody
    public ResponseVo updateReceiving(@RequestBody ReceivingInfEntity receivingInfEntity){
        boolean result = receivingInfService.updateReceivingInf(receivingInfEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "收货信息修改成功" : "收货信息修改失败")
                .data(result)
                .build();
    }


    /**
     * 修改默认地址
     * @param receivingInfEntity 接收要修改的信息
     * @return
     */
    @PostMapping("/update/default")
    @ResponseBody
    public ResponseVo updateDefault(@RequestBody ReceivingInfEntity receivingInfEntity){
        boolean result = receivingInfService.updateDefault(receivingInfEntity.getReceivingInfId(), receivingInfEntity.getLoginId());
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "默认地址修改成功" : "默认地址修改失败")
                .data(result)
                .build();
    }

    /**
     * 删除收货信息
     * @param receivingInfEntity 接收要删除的信息
     * @return
     */
    @PostMapping("/delete/receiving")
    @ResponseBody
    public ResponseVo deleteReceiving(@RequestBody ReceivingInfEntity receivingInfEntity){
        boolean result = receivingInfService.deleteReceivingInf(receivingInfEntity.getReceivingInfId());
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "收货信息删除成功" : "收货信息删除失败")
                .data(result)
                .build();
    }
}
