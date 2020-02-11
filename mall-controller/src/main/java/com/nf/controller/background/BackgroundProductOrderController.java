package com.nf.controller.background;

import com.github.pagehelper.PageInfo;
import com.nf.entity.ProductOrderEntity;
import com.nf.entity.ReceivingInfEntity;
import com.nf.service.port.ProductOrderService;
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
 * @Classname BackgroundProductOrderController
 * @Date: 2020-02-10 18:39
 * @Description:
 */
@Controller
@RequestMapping("/mall/background/product/order")
public class BackgroundProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @GetMapping("/home")
    public String homeView(){
        return "background/product-order/productOrder";
    }

    /**
     * 订单信息的条件查询
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param receivingInfEntity 用来接收查询条件
     * @return
     */
    @GetMapping("/condition/page/data")
    @ResponseBody
    public ResponseVo conditionPageData(@RequestParam(value = "pageNum", required = false, defaultValue = "1")Integer pageNum,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                        ReceivingInfEntity receivingInfEntity){

        boolean result;
        List<ProductOrderEntity> productOrderEntities;
        PageInfo pageInfo = null;
        try{
            productOrderEntities = productOrderService.getPageByCondition(pageNum, pageSize, receivingInfEntity);
            pageInfo = new PageInfo(productOrderEntities, 5);
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

}
