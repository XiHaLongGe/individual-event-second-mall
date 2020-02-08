package com.nf.dao.port;

import com.nf.entity.ProductCartEntity;
import com.nf.entity.ProductOrderEntity;
import com.nf.entity.ReceivingInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderDao
 * @Date: 2020-02-08 08:01
 * @Description: 订单表dao层接口
 */
public interface ProductOrderDao {
    /**
     * 获得属于订单编号的收货信息
     * @param productOrderNumber 订单编号
     * @return
     */
    ReceivingInfEntity getReceivingData(@Param("productOrderNumber") String productOrderNumber);

    /**
     * 获得属于订单编号的商品信息
     * @param productOrderNumber 订单编号
     * @return
     */
    List<ProductCartEntity> getSubmitData(@Param("productOrderNumber") String productOrderNumber);

    /**
     * 添加订单信息(商品信息界面结算)
     * @param productCartEntity 用来保存添加的订单信息
     * @return
     */
    Integer insertSingleProductOrder(@Param("productCartEntity") ProductCartEntity productCartEntity, @Param("productOrderNumber")String productOrderNumber);

    /**
     * 添加订单信息（购物车中结算）
     * @param productCartEntities 用来保存添加的订单信息
     * @param productOrderNumber 订单编号
     * @return
     */
    Integer insertCartProductOrder(@Param("productCartEntities") List<ProductCartEntity> productCartEntities, @Param("productOrderNumber")String productOrderNumber);


    /**
     * 提交订单操作
     * @param productOrderEntity 提交订单信息
     * @return
     */
    Integer submitOrder(@Param("productOrderEntity") ProductOrderEntity productOrderEntity);


    /**
     * 付款成功修改订单信息
     * @param productOrderNumber 订单编号
     * @return
     */
    Integer paymentOrder(@Param("productOrderNumber") String productOrderNumber);


    /**
     * 对用户没有下单的订单进行删除
     * @param productOrderNumber 订单编号
     * @return
     */
    Integer deleteOrder(@Param("productOrderNumber") String productOrderNumber);
}
