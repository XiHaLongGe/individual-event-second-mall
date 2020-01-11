package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
                ", customerIndividualId=" + customerIndividualId +
                ", receivingInfName='" + receivingInfName + '\'' +
                ", receivingInfPhone='" + receivingInfPhone + '\'' +
                ", receivingInfProvince='" + receivingInfProvince + '\'' +
                ", receivingInfCity='" + receivingInfCity + '\'' +
                ", receivingInfDistrict='" + receivingInfDistrict + '\'' +
                ", receivingInfAddress='" + receivingInfAddress + '\'' +
                '}';
    }

    /**
     * receiving_inf_id: 收货信息表ID
     */
    private Integer receivingInfId;
    /**
     * customer_individual_id: 用户信息表ID
     */
    private Integer customerIndividualId;
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
}
