package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname ProductCartEntity
 * @Date: 2020-01-09 22:53
 * @Description: 购物车表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCartEntity {

    @Override
    public String toString() {
        return "ProductCartEntity{" +
                "productCartId=" + productCartId +
                ", customerIndividualId=" + customerIndividualId +
                ", productInfId=" + productInfId +
                ", productCartNum=" + productCartNum +
                '}';
    }

    /**
     * product_cart_id: 购物车表ID
     */
    private Integer productCartId;
    /**
     * customer_individual_id: 用户信息表ID
     */
    private Integer customerIndividualId;
    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * product_cart_num: 商品数量
     */
    private Integer productCartNum;
}
