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
                ", productCategoryColumn=" + productCategoryColumn +
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
     * product_category_column: 是否属于栏目类型
     *                          0 : "否"
     *                          1 : "是"
     */
    private Byte productCategoryColumn;
    /**
     * product_category_level: 类型层级
     */
    private Integer productCategoryLevel;
    /**
     * parent_id: 父类型ID
     */
    private String parentId;
}
