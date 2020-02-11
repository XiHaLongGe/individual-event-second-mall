package com.nf.service.port;

import com.nf.entity.ProductCartEntity;
import com.nf.entity.ProductOrderEntity;
import com.nf.entity.ReceivingInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderService
 * @Date: 2020-02-08 08:13
 * @Description: 订单信息service层接口
 */
public interface ProductOrderService {
    /**
     * 订单信息的条件查询
     * @param pageNum 用来接收当前页数
     * @param pageSize 用来接收每页显示的条目
     * @param receivingInfEntity 用来接收查询条件
     * @return
     */
    List<ProductOrderEntity> getPageByCondition(Integer pageNum,
                                                Integer pageSize,
                                                ReceivingInfEntity receivingInfEntity);
    /**
     * 获得属于订单编号的收货信息
     * @param productOrderNumber 订单编号
     * @return
     */
    ReceivingInfEntity getReceivingData(String productOrderNumber);


    /**
     * 获取到相应订单状态的列表数据
     * @param loginId 登录id
     * @param state 订单状态
     * @return
     */
    List<ProductOrderEntity> getCategoryListData(Integer loginId, Integer state);


    /**
     * 获取到相应订单状态的数据条目
     * @param loginId 登录id
     * @param state 订单状态
     * @return
     */
    Integer getCategoryCountData(Integer loginId, Integer state);

    /**
     * 获得属于订单编号的商品信息
     * @param productOrderNumber 订单编号
     * @return
     */
    List<ProductOrderEntity> getSubmitData(String productOrderNumber);
    /**
     * 添加订单信息(商品信息界面结算)
     * @param productCartEntity 用来保存添加的订单信息
     * @return
     */
    String insertSingleProductOrder(ProductCartEntity productCartEntity);


    /**
     * 添加订单信息（购物车中结算）
     * @param productCartEntities 用来保存添加的订单信息
     * @return
     */
    String insertCartProductOrder(List<ProductCartEntity> productCartEntities);

    /**
     * 提交订单操作
     * @param productOrderEntity 提交订单信息
     * @return
     */
    boolean submitOrder(ProductOrderEntity productOrderEntity);



    /**
     * 付款成功修改订单信息
     * @param productOrderNumber 订单编号
     * @return
     */
    boolean paymentOrder(String productOrderNumber);

    /**
     * 确认收货
     * @param productOrderNumber 订单编号
     * @return
     */
    boolean confirmReceipt(String productOrderNumber);


    /**
     * 对用户没有下单的订单进行删除
     * @param productOrderNumber 订单编号
     * @return
     */
    boolean deleteOrder(String productOrderNumber);
}
