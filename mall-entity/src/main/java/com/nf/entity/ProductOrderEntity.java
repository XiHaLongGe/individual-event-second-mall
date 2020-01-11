package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LJP
 * @Classname ProductOrderEntity
 * @Date: 2020-01-09 22:54
 * @Description: 商品订单表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderEntity {

    @Override
    public String toString() {
        return "ProductOrderEntity{" +
                "productOrderId=" + productOrderId +
                ", customerIndividualId=" + customerIndividualId +
                ", receivingInfId=" + receivingInfId +
                ", productInfId=" + productInfId +
                ", productNum=" + productNum +
                ", leaveWord='" + leaveWord + '\'' +
                ", payment=" + payment +
                ", submitTime=" + submitTime +
                ", paymentTime=" + paymentTime +
                ", productOrderState=" + productOrderState +
                ", productOrderNumber='" + productOrderNumber + '\'' +
                '}';
    }

    /**
     * product_order_id: 商品订单表ID
     */
    private Integer productOrderId;
    /**
     * customer_individual_id: 用户信息表ID
     */
    private Integer customerIndividualId;
    /**
     * receiving_inf_id: 收货信息表ID
     */
    private Integer receivingInfId;
    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * product_num: 商品数量
     */
    private Integer productNum;
    /**
     * leave_word: 用户留言
     */
    private String leaveWord;
    /**
     * payment: 支付方式
     *                          0 : "未支付"
     *                          1 : "支付宝"
     *                          2 : "微信"
     *                          3 : "现金"
     */
    private Integer payment;
    /**
     * submit_time: 下单时间
     */
    private Date submitTime;
    /**
     * payment_time: 付款时间
     */
    private Date paymentTime;
    /**
     * product_order_state: 订单状态
     *                          1 : "待付款"
     *                          2 : "待收货"
     *                          3 : "已收货"
     */
    private Integer productOrderState;
    /**
     * product_order_number: 订单编号
     */
    private String productOrderNumber;
}
