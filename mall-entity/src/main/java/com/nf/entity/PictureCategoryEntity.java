package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname PictureCategoryEntity
 * @Date: 2020-01-09 22:52
 * @Description: 图片类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureCategoryEntity {

    @Override
    public String toString() {
        return "PictureCategoryEntity{" +
                "pictureCategoryId=" + pictureCategoryId +
                ", pictureCategoryName='" + pictureCategoryName + '\'' +
                '}';
    }

    /**
     * picture_category_id: 图片类型表ID
     */
    private Integer pictureCategoryId;
    /**
     * picture_category_name: 图片类型名称
     */
    private String pictureCategoryName;
}
