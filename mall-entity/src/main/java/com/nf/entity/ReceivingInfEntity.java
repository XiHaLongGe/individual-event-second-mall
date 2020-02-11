package com.nf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: LJP
 * @Classname ReceivingInfEntity
 * @Date: 2020-01-09 22:53
 * @Description: 收货信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceivingInfEntity {
    @Override
    public String toString() {
        return "ReceivingInfEntity{" +
                "receivingInfId=" + receivingInfId +
                ", loginId=" + loginId +
                ", receivingInfName='" + receivingInfName + '\'' +
                ", receivingInfPhone='" + receivingInfPhone + '\'' +
                ", receivingInfProvince='" + receivingInfProvince + '\'' +
                ", receivingInfCity='" + receivingInfCity + '\'' +
                ", receivingInfDistrict='" + receivingInfDistrict + '\'' +
                ", receivingInfAddress='" + receivingInfAddress + '\'' +
                ", receivingInfDefault=" + receivingInfDefault +
                ", productInfName='" + productInfName + '\'' +
                ", productInfPrice=" + productInfPrice +
                ", productOrderNumber='" + productOrderNumber + '\'' +
                ", productNum=" + productNum +
                '}';
    }

    /**
     * receiving_inf_id: 收货信息表ID
     */
    private Integer receivingInfId;
    /**
     * login_id: 用户登录表ID
     */
    private Integer loginId;
    /**
     * receiving_inf_name: 收货人姓名
     */
    private String receivingInfName;
    /**
     * receiving_inf_phone: 收货人手机号
     */
        private String receivingInfPhone;
    /**
     * receiving_inf_province: 收货人省份/自治区
     */
    private String receivingInfProvince;
    /**
     * receiving_inf_city: 收货人城市/地区/自治州
     */
    private String receivingInfCity;
    /**
     * receiving_inf_district: 收货人区/县
     */
    private String receivingInfDistrict;
    /**
     * receiving_inf_address: 收货人详细地址
     */
    private String receivingInfAddress;
    /**
     * receiving_inf_default: 是否为默认地址(0:"否",1:"是")
     */
    private Byte receivingInfDefault;

    /*===================================   扩展字段   begin   ================================*/


    /**
     * product_order_id: 商品订单表ID
     */
    private Integer productOrderId;
    /**
     * productInfName: 商品名称
     */
    private String productInfName;
    /**
     * product_inf_price: 商品价格
     */
    private BigDecimal productInfPrice;
    /**
     * product_num: 商品数量
     */
    private Integer productNum;
    /**
     * product_order_number: 订单编号
     */
    private String productOrderNumber;
    /**
     * beginTime: 开始时间
     */
    private Date beginTime;
    /**
     * endTime: 结束时间
     */
    private Date endTime;
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


    /*===================================   扩展字段   end   ==================================*/
}
