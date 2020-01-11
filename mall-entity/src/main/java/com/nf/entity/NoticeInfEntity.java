package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LJP
 * @Classname NoticeInfEntity
 * @Date: 2020-01-09 22:54
 * @Description: 公告信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeInfEntity {

    @Override
    public String toString() {
        return "NoticeInfEntity{" +
                "noticeInfId=" + noticeInfId +
                ", noticeCategoryId=" + noticeCategoryId +
                ", noticeInfTitle='" + noticeInfTitle + '\'' +
                ", noticeInfContent='" + noticeInfContent + '\'' +
                ", noticeTime=" + noticeTime +
                '}';
    }

    /**
     * notice_inf_id: 公告信息表ID
     */
    private Integer noticeInfId;
    /**
     * notice_category_id: 公告类型表ID
     */
    private Integer noticeCategoryId;
    /**
     * notice_inf_title: 公告标题
     */
    private String noticeInfTitle;
    /**
     * notice_inf_content: 公告内容
     */
    private String noticeInfContent;
    /**
     * notice_time: 公告发布时间
     */
    private Date noticeTime;
}
