package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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


    /*===================================   扩展字段   begin   ================================*/
    /**
     * productInfIdArray: 用来接收批量删除的商品id
     */
    private Integer[] productInfIdArray;
    /**
     * productInfName: 商品名称
     */
    private String productInfName;
    /**
     * product_inf_describe: 商品描述
     */
    private String productInfDescribe;
    /**
     * product_inf_price: 商品价格
     */
    private BigDecimal productInfPrice;
    /**
     * brandInfId: 品牌信息表ID
     */
    private Integer brandInfId;
    /**
     * brandInfName: 品牌名称
     */
    private String brandInfName;
    /**
     * pictureInfUrl: 图片路径
     */
    private String pictureInfUrl;
    /**
     * productOrderNumber: 订单编号
     */
    private String productOrderNumber;



    /*===================================   扩展字段   end   ==================================*/



    private ProductCartEntity(Builder builder) {
        productCartId = builder.productCartId;
        loginId = builder.loginId;
        productInfId = builder.productInfId;
        productCartNum = builder.productCartNum;
        productInfIdArray = builder.productInfIdArray;
        productInfName = builder.productInfName;
        productInfDescribe = builder.productInfDescribe;
        productInfPrice = builder.productInfPrice;
        brandInfId = builder.brandInfId;
        brandInfName = builder.brandInfName;
        pictureInfUrl = builder.pictureInfUrl;
        productOrderNumber = builder.productOrderNumber;
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
        builder.productInfIdArray = copy.getProductInfIdArray();
        builder.productInfName = copy.getProductInfName();
        builder.productInfDescribe = copy.getProductInfDescribe();
        builder.productInfPrice = copy.getProductInfPrice();
        builder.brandInfId = copy.getBrandInfId();
        builder.brandInfName = copy.getBrandInfName();
        builder.pictureInfUrl = copy.getPictureInfUrl();
        builder.productOrderNumber = copy.getProductOrderNumber();
        return builder;
    }


    public static final class Builder {
        private Integer productCartId;
        private Integer loginId;
        private Integer productInfId;
        private Integer productCartNum;
        private Integer[] productInfIdArray;
        private String productInfName;
        private String productInfDescribe;
        private BigDecimal productInfPrice;
        private Integer brandInfId;
        private String brandInfName;
        private String pictureInfUrl;
        private String productOrderNumber;

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

        public Builder productInfIdArray(Integer[] val) {
            productInfIdArray = val;
            return this;
        }

        public Builder productInfName(String val) {
            productInfName = val;
            return this;
        }

        public Builder productInfDescribe(String val) {
            productInfDescribe = val;
            return this;
        }

        public Builder productInfPrice(BigDecimal val) {
            productInfPrice = val;
            return this;
        }

        public Builder brandInfId(Integer val) {
            brandInfId = val;
            return this;
        }

        public Builder brandInfName(String val) {
            brandInfName = val;
            return this;
        }

        public Builder pictureInfUrl(String val) {
            pictureInfUrl = val;
            return this;
        }

        public Builder productOrderNumber(String val) {
            productOrderNumber = val;
            return this;
        }

        public ProductCartEntity build() {
            return new ProductCartEntity(this);
        }
    }





}
