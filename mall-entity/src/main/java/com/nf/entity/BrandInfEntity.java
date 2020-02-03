package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname BrandInfEntity
 * @Date: 2020-01-09 22:51
 * @Description: 品牌信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandInfEntity {
    @Override
    public String toString() {
        return "BrandInfEntity{" +
                "brandInfId=" + brandInfId +
                ", brandInfName='" + brandInfName + '\'' +
                '}';
    }

    /**
     * brand_inf_id: 品牌信息表ID
     */
    private Integer brandInfId;
    /**
     * brand_inf_name: 品牌名称
     */
    private String brandInfName;



    /*===================================   扩展字段   begin   ==================================*/

    /**
     * pbrId: pbr关联表ID
     */
    private Integer pbrId;
    /**
     * product_category_id: 商品类型表ID
     */
    private String productCategoryId;
    /**
     * productCategoryName: 类型名称
     */
    private String productCategoryName;

    /*===================================   扩展字段   end   ==================================*/
}
