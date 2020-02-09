package com.nf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
                ", loginId=" + loginId +
                ", receivingInfId=" + receivingInfId +
                ", productInfId=" + productInfId +
                ", productNum=" + productNum +
                ", leaveWord='" + leaveWord + '\'' +
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
     * loginId: 用户登录表ID
     */
    private Integer loginId;
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
     * submit_time: 下单时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date submitTime;
    /**
     * payment_time: 付款时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date paymentTime;
    /**
     * product_order_state: 订单状态
     *                          0 : "交易关闭"
     *                          1 : "待付款"
     *                          2 : "待收货"
     *                          3 : "已收货"
     *                          4 : "交易成功"
     */
    private Integer productOrderState;
    /**
     * product_order_number: 订单编号
     */
    private String productOrderNumber;

    /*===================================   扩展字段   begin   ================================*/



    /**
     * productInfName: 商品名称
     */
    private String productInfName;
    /**
     * product_inf_price: 商品价格
     */
    private BigDecimal productInfPrice;
    /**
     * pictureInfUrl: 图片路径
     */
    private String pictureInfUrl;


    /*===================================   扩展字段   end   ==================================*/
}
