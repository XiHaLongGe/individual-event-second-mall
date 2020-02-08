package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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
     * productInfName: 商品名称
     */
    private String productInfName;
    /**
     * product_inf_price: 商品价格
     */
    private BigDecimal productInfPrice;
    /**
     * product_order_number: 订单编号
     */
    private String productOrderNumber;
    /**
     * product_num: 商品数量
     */
    private Integer productNum;


    /*===================================   扩展字段   end   ==================================*/
}
