package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: LJP
 * @Classname CustomerLoginEntity
 * @Date: 2020-01-09 22:50
 * @Description: 用户登录表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginEntity {
    @Override
    public String toString() {
        return "CustomerLoginEntity{" +
                "loginId=" + loginId +
                ", headIconUrl='" + headIconUrl + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", activateCode='" + activateCode + '\'' +
                ", accountStats=" + accountStats +
                ", creationTime=" + creationTime +
                '}';
    }

    /**
     * loginId: 用户登录表ID
     */
    private Integer loginId;

    /**
     * headIconUrl: 头像路径
     */
    private String headIconUrl;

    /**
     * loginName: 昵称
     */
    private String loginName;

    /**
     * loginAccount: 登录账号
     */
    private String loginAccount;

    /**
     * loginPassword: 登录密码
     */
    private String loginPassword;

    /**
     * activateCode: 邮箱激活码
     */
    private String activateCode;

    /**
     * accountStats: 账号状态
     *              0:"未激活"
     *              1:"激活"
     */
    private Byte accountStats;

    /**
     * creationTime: 账号创建日期
     */
    private Date creationTime;
}
