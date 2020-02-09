package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: LJP
 * @Classname ProductInfEntity
 * @Date: 2020-01-09 22:51
 * @Description: 商品信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfEntity {

    @Override
    public String toString() {
        return "ProductInfEntity{" +
                "productInfId=" + productInfId +
                ", brandInfId=" + brandInfId +
                ", productCategoryId='" + productCategoryId + '\'' +
                ", productInfName='" + productInfName + '\'' +
                ", productInfDescribe='" + productInfDescribe + '\'' +
                ", productInfPrice=" + productInfPrice +
                ", productInfSales=" + productInfSales +
                ", productInfStockpile=" + productInfStockpile +
                ", productInfCarousel=" + productInfCarousel +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", brandInfName='" + brandInfName + '\'' +
                '}';
    }

    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * brand_inf_id: 品牌信息表ID
     */
    private Integer brandInfId;
    /**
     * product_category_id: 商品类型表ID
     */
    private String productCategoryId;
    /**
     * product_inf_name: 商品名称
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
     * product_inf_sales: 商品销量
     */
    private Integer productInfSales;
    /**
     * product_inf_stockpile: 商品库存
     */
    private Integer productInfStockpile;
    /**
     * productInfCarousel: 是否轮播展示(0:"否",1:"是")
     */
    private Byte productInfCarousel;


    /*===================================   扩展字段   begin   ================================*/

    /**
     * productCategoryName: 类型名称
     */
    private String productCategoryName;
    /**
     * brandInfName: 品牌名称
     */
    private String brandInfName;
    /**
     * pictureInfUrl: 图片路径
     */
    private String pictureInfUrl;
    /**
     * beginPrice: 起始价格
     */
    private BigDecimal beginPrice;
    /**
     * endPrice：截至价格
     */
    private BigDecimal endPrice;


    /*===================================   扩展字段   end   ==================================*/

    private ProductInfEntity(Builder builder) {
        productInfId = builder.productInfId;
        brandInfId = builder.brandInfId;
        productCategoryId = builder.productCategoryId;
        productInfName = builder.productInfName;
        productInfDescribe = builder.productInfDescribe;
        productInfPrice = builder.productInfPrice;
        productInfSales = builder.productInfSales;
        productInfStockpile = builder.productInfStockpile;
        productInfCarousel = builder.productInfCarousel;
        productCategoryName = builder.productCategoryName;
        brandInfName = builder.brandInfName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductInfEntity copy) {
        Builder builder = new Builder();
        builder.productInfId = copy.getProductInfId();
        builder.brandInfId = copy.getBrandInfId();
        builder.productCategoryId = copy.getProductCategoryId();
        builder.productInfName = copy.getProductInfName();
        builder.productInfDescribe = copy.getProductInfDescribe();
        builder.productInfPrice = copy.getProductInfPrice();
        builder.productInfSales = copy.getProductInfSales();
        builder.productInfStockpile = copy.getProductInfStockpile();
        builder.productInfCarousel = copy.getProductInfCarousel();
        builder.productCategoryName = copy.getProductCategoryName();
        builder.brandInfName = copy.getBrandInfName();
        return builder;
    }

    public static final class Builder {
        private Integer productInfId;
        private Integer brandInfId;
        private String productCategoryId;
        private String productInfName;
        private String productInfDescribe;
        private BigDecimal productInfPrice;
        private Integer productInfSales;
        private Integer productInfStockpile;
        private Byte productInfCarousel;
        private String productCategoryName;
        private String brandInfName;

        private Builder() {
        }

        public Builder productInfId(Integer val) {
            productInfId = val;
            return this;
        }

        public Builder brandInfId(Integer val) {
            brandInfId = val;
            return this;
        }

        public Builder productCategoryId(String val) {
            productCategoryId = val;
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

        public Builder productInfSales(Integer val) {
            productInfSales = val;
            return this;
        }

        public Builder productInfStockpile(Integer val) {
            productInfStockpile = val;
            return this;
        }

        public Builder productInfCarousel(Byte val) {
            productInfCarousel = val;
            return this;
        }

        public Builder productCategoryName(String val) {
            productCategoryName = val;
            return this;
        }

        public Builder brandInfName(String val) {
            brandInfName = val;
            return this;
        }

        public ProductInfEntity build() {
            return new ProductInfEntity(this);
        }
    }


}
