package com.nf.controller.foreground;

import com.nf.entity.ProductCartEntity;
import com.nf.entity.ProductOrderEntity;
import com.nf.entity.ReceivingInfEntity;
import com.nf.service.port.ProductOrderService;
import com.nf.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ForegroundProductOrderController
 * @Date: 2020-02-07 22:58
 * @Description: 订单信息表控制器
 */
@Controller
@RequestMapping("/mall/foreground/product/order")
public class ForegroundProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;
    /**
     * 订单信息视图
     * @return
     */
    @GetMapping("/home")
    public String homeView(Model model, String productOrderNumber){
        model.addAttribute("productOrderNumber", productOrderNumber);
        return "foreground/product-order/submitOrder";
    }

    /**
     * 订单的分类视图：待付款 待发货 待收货
     * @return
     */
    @GetMapping("/category")
    public String categoryView(){
        return "foreground/personal/productOrderInf";
    }

    /**
     * 订单提交成功视图
     * @return
     */
    @GetMapping("/success/submit")
    public String successSubmitView(Model model, String productOrderNumber){
        model.addAttribute("productOrderNumber", productOrderNumber);
        return "foreground/product-order/successSubmit";
    }

    /**
     * 订单付款成功视图
     * @return
     */
    @GetMapping("/payment/success")
    public String paymentSuccessView(){
        return "foreground/product-order/paymentSuccess";
    }

    /**
     * 订单付款成功视图
     * @return
     */
    @GetMapping("/payment/loser")
    public String paymentLoserView(){
        return "foreground/product-order/paymentLoser";
    }


    /**
     * 获取到相应订单状态的数据条目
     * @param loginId 登录id
     * @param state 订单状态
     * @return
     */
    @GetMapping("/state/count/data")
    @ResponseBody
    public ResponseVo categoryCountData(Integer loginId, Integer state){
        boolean result = true;
        Integer stateDataNum = null;
        try{
            stateDataNum = productOrderService.getCategoryCountData(loginId, state);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(stateDataNum)
                .build();
    }

    /**
     * 获取到相应订单状态的列表数据
     * @param loginId 登录id
     * @param state 订单状态
     * @return
     */
    @GetMapping("/state/list/data")
    @ResponseBody
    public ResponseVo categoryListData(Integer loginId, Integer state){
        boolean result = true;
        List<ProductOrderEntity> productOrderEntities = null;
        try{
            productOrderEntities = productOrderService.getCategoryListData(loginId, state);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productOrderEntities)
                .build();
    }




    /**
     * 获得属于订单编号的商品信息
     * @param productOrderNumber 订单编号
     * @return
     */
    @GetMapping("/submit/data")
    @ResponseBody
    public ResponseVo submitData(String productOrderNumber){
        boolean result = true;
        List<ProductOrderEntity> productCartEntities = null;
        try{
            productCartEntities = productOrderService.getSubmitData(productOrderNumber);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(productCartEntities)
                .build();
    }

    /**
     * 获得属于订单编号的收货信息
     * @param productOrderNumber 订单编号
     * @return
     */
    @GetMapping("/receiving/data")
    @ResponseBody
    public ResponseVo receivingData(String productOrderNumber){
        boolean result = true;
        ReceivingInfEntity receivingInfEntity = null;
        try{
            receivingInfEntity = productOrderService.getReceivingData(productOrderNumber);
            System.out.println(receivingInfEntity);
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "数据获取成功" : "数据获取失败")
                .data(receivingInfEntity)
                .build();
    }


    /**
     * 添加订单信息(商品信息界面结算)
     * @param productCartEntity 用来保存添加的订单信息
     * @return
     */
    @PostMapping("/single/add/order")
    @ResponseBody
    public ResponseVo addOrder(@RequestBody ProductCartEntity productCartEntity){
        String productOrderNumber = productOrderService.insertSingleProductOrder(productCartEntity);
        boolean result = !productOrderNumber.isEmpty();
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "订单添加成功" : "订单添加失败")
                .data(productOrderNumber)
                .build();
    }

    /**
     * 添加订单信息（购物车中结算）
     * @param productCartEntities 用来保存添加的订单信息
     * @return
     */
    @PostMapping("/cart/add/order")
    @ResponseBody
    public ResponseVo cartAddOrder(@RequestBody List<ProductCartEntity> productCartEntities){
        String productOrderNumber = productOrderService.insertCartProductOrder(productCartEntities);
        boolean result = !productOrderNumber.isEmpty();
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "订单添加成功" : "订单添加失败")
                .data(productOrderNumber)
                .build();
    }

    /**
     * 提交订单操作
     * @param productOrderEntity 提交订单信息
     * @return
     */
    @PostMapping("/submit/order")
    @ResponseBody
    public ResponseVo submitOrder(@RequestBody ProductOrderEntity productOrderEntity){
        boolean result = productOrderService.submitOrder(productOrderEntity);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "订单提交成功" : "订单提交失败")
                .data(result)
                .build();
    }


    /*/**
     * 付款后修改订单信息
     * @param productOrderNumber 订单编号
     * @return
     */
    /*@PostMapping("/payment/order")
    @ResponseBody
    public ResponseVo paymentOrder(String productOrderNumber){
        boolean result = productOrderService.paymentOrder(productOrderNumber);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "订单付款成功" : "订单付款失败")
                .data(result)
                .build();
    }*/

    /**
     * 确认收货
     * @param productOrderNumber 订单编号
     * @return
     */
    @PostMapping("/confirm/receipt")
    @ResponseBody
    public ResponseVo confirmReceipt(@RequestParam("productOrderNumber") String productOrderNumber){
        boolean result = productOrderService.confirmReceipt(productOrderNumber);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "确认收货成功" : "确认收货失败")
                .data(result)
                .build();
    }


    /**
     * 对用户没有下单的订单进行删除
     * @param productOrderNumber 订单编号
     * @return
     */
    @PostMapping("/delete/order")
    @ResponseBody
    public ResponseVo deleteOrder(@RequestParam("productOrderNumber") String productOrderNumber){
        boolean result = productOrderService.deleteOrder(productOrderNumber);
        return ResponseVo.newBuilder()
                .code(result ? 200 : 500)
                .message(result ? "订单删除成功" : "订单删除失败")
                .data(result)
                .build();
    }
}
