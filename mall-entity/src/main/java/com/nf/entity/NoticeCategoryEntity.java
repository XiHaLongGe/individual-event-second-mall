package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname NoticeCategoryEntity
 * @Date: 2020-01-09 22:54
 * @Description: 公告类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeCategoryEntity {

    @Override
    public String toString() {
        return "NoticeCategoryEntity{" +
                "noticeCategoryId=" + noticeCategoryId +
                ", noticeCategoryName='" + noticeCategoryName + '\'' +
                '}';
    }

    /**
     * notice_category_id: 公告类型表ID
     */
    private Integer noticeCategoryId;
    /**
     * notice_category_name: 公告类型名称
     */
    private String noticeCategoryName;
}
