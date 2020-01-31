package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname ProductCategoryEntity
 * @Date: 2020-01-09 22:51
 * @Description: 商品类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryEntity {

    @Override
    public String toString() {
        return "ProductCategoryEntity{" +
                "productCategoryId='" + productCategoryId + '\'' +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", sidebarCategoryDescribe='" + sidebarCategoryDescribe + '\'' +
                ", productCategoryLevel=" + productCategoryLevel +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    /**
     * product_category_id: 商品类型表ID
     */
    private String productCategoryId;
    /**
     * product_category_name: 类型名称
     */
    private String productCategoryName;
    /**
     * sidebar_category_describe: 类型描述
     */
    private String sidebarCategoryDescribe;
    /**
     * product_category_level: 类型层级
     */
    private Integer productCategoryLevel;
    /**
     * parent_id: 父类型ID
     */
    private String parentId;


    /*===================================   扩展字段   begin   ==================================*/

    /**
     * parentCategoryName: 父类型名称
     */
    private String parentCategoryName;

    /*===================================   扩展字段   end   ==================================*/



    private ProductCategoryEntity(Builder builder) {
        productCategoryId = builder.productCategoryId;
        productCategoryName = builder.productCategoryName;
        sidebarCategoryDescribe = builder.sidebarCategoryDescribe;
        productCategoryLevel = builder.productCategoryLevel;
        parentId = builder.parentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ProductCategoryEntity copy) {
        Builder builder = new Builder();
        builder.productCategoryId = copy.getProductCategoryId();
        builder.productCategoryName = copy.getProductCategoryName();
        builder.sidebarCategoryDescribe = copy.getSidebarCategoryDescribe();
        builder.productCategoryLevel = copy.getProductCategoryLevel();
        builder.parentId = copy.getParentId();
        return builder;
    }

    public static final class Builder {
        private String productCategoryId;
        private String productCategoryName;
        private String sidebarCategoryDescribe;
        private Integer productCategoryLevel;
        private String parentId;

        private Builder() {
        }

        public Builder productCategoryId(String val) {
            productCategoryId = val;
            return this;
        }

        public Builder productCategoryName(String val) {
            productCategoryName = val;
            return this;
        }

        public Builder sidebarCategoryDescribe(String val) {
            sidebarCategoryDescribe = val;
            return this;
        }

        public Builder productCategoryLevel(Integer val) {
            productCategoryLevel = val;
            return this;
        }

        public Builder parentId(String val) {
            parentId = val;
            return this;
        }

        public ProductCategoryEntity build() {
            return new ProductCategoryEntity(this);
        }
    }


}
