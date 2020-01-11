package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname PictureInfEntity
 * @Date: 2020-01-09 22:52
 * @Description: 图片信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureInfEntity {

    @Override
    public String toString() {
        return "PictureInfEntity{" +
                "pictureInfId=" + pictureInfId +
                ", pictureCategoryId=" + pictureCategoryId +
                ", productInfId=" + productInfId +
                ", pictureInfUrl='" + pictureInfUrl + '\'' +
                ", pictureInfOrder=" + pictureInfOrder +
                '}';
    }

    /**
     * picture_inf_id: 图片信息表ID
     */
    private Integer pictureInfId;
    /**
     * picture_category_id: 图片类型表ID
     */
    private Integer pictureCategoryId;
    /**
     * product_inf_id: 商品信息表ID
     */
    private Integer productInfId;
    /**
     * picture_inf_url: 图片路径
     */
    private String pictureInfUrl;
    /**
     * picture_inf_order: 图片排序
     */
    private Integer pictureInfOrder;
}
