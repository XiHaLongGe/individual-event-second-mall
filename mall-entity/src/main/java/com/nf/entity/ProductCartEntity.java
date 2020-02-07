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
                ", loginId=" + loginId +
                ", productInfId=" + productInfId +
                ", productCartNum=" + productCartNum +
                '}';
    }

    /**
     * productCartId: 购物车表ID
     */
    private Integer productCartId;
    /**
     * loginId: 用户登录表ID
     */
    private Integer loginId;
    /**
     * productInfId: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * productCartNum: 商品数量
     */
    private Integer productCartNum;


    private ProductCartEntity(Builder builder) {
        productCartId = builder.productCartId;
        loginId = builder.loginId;
        productInfId = builder.productInfId;
        productCartNum = builder.productCartNum;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductCartEntity copy) {
        Builder builder = new Builder();
        builder.productCartId = copy.getProductCartId();
        builder.loginId = copy.getLoginId();
        builder.productInfId = copy.getProductInfId();
        builder.productCartNum = copy.getProductCartNum();
        return builder;
    }

    public static final class Builder {
        private Integer productCartId;
        private Integer loginId;
        private Integer productInfId;
        private Integer productCartNum;

        private Builder() {
        }

        public Builder productCartId(Integer val) {
            productCartId = val;
            return this;
        }

        public Builder loginId(Integer val) {
            loginId = val;
            return this;
        }

        public Builder productInfId(Integer val) {
            productInfId = val;
            return this;
        }

        public Builder productCartNum(Integer val) {
            productCartNum = val;
            return this;
        }

        public ProductCartEntity build() {
            return new ProductCartEntity(this);
        }
    }
}
