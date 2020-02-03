package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname ProCategoryBrandInfRelevanceEntity
 * @Date: 2020-02-02 21:03
 * @Description: 商品类型与品牌信息关联表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProCategoryBrandInfRelevanceEntity {
    private ProCategoryBrandInfRelevanceEntity(Builder builder) {
        pbrId = builder.pbrId;
        productCategoryId = builder.productCategoryId;
        brandInfId = builder.brandInfId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProCategoryBrandInfRelevanceEntity copy) {
        Builder builder = new Builder();
        builder.pbrId = copy.getPbrId();
        builder.productCategoryId = copy.getProductCategoryId();
        builder.brandInfId = copy.getBrandInfId();
        return builder;
    }

    @Override
    public String toString() {
        return "ProCategoryBrandInfRelevanceEntity{" +
                "pbrId=" + pbrId +
                ", productCategoryId='" + productCategoryId + '\'' +
                ", brandInfId=" + brandInfId +
                '}';
    }

    /**
     * pbrId: pbr关联表ID
     */
    private Integer pbrId;
    /**
     * productCategoryId: 商品类型表ID
     */
    private String productCategoryId;
    /**
     * brandInfId: 品牌信息表ID
     */
    private Integer brandInfId;


    public static final class Builder {
        private Integer pbrId;
        private String productCategoryId;
        private Integer brandInfId;

        private Builder() {
        }

        public Builder pbrId(Integer val) {
            pbrId = val;
            return this;
        }

        public Builder productCategoryId(String val) {
            productCategoryId = val;
            return this;
        }

        public Builder brandInfId(Integer val) {
            brandInfId = val;
            return this;
        }

        public ProCategoryBrandInfRelevanceEntity build() {
            return new ProCategoryBrandInfRelevanceEntity(this);
        }
    }


    /*===================================   扩展字段   begin   ==================================*/

    /**
     * brandInfName: 品牌名称
     */
    private String brandInfName;
    /**
     * productCategoryName: 类型名称
     */
    private String productCategoryName;

    /*===================================   扩展字段   end   ==================================*/
}
