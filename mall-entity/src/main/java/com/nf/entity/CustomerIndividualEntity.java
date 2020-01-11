package com.nf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: LJP
 * @Classname CustomerIndividualEntity
 * @Date: 2020-01-09 22:51
 * @Description: 用户信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerIndividualEntity {
    @Override
    public String toString() {
        return "CustomerIndividualEntity{" +
                "customerIndividualId=" + customerIndividualId +
                ", loginId=" + loginId +
                ", customerIndividualName='" + customerIndividualName + '\'' +
                ", customerIndividualGender=" + customerIndividualGender +
                ", customerIndividualCard='" + customerIndividualCard + '\'' +
                ", customerIndividualPhone='" + customerIndividualPhone + '\'' +
                ", customerIndividualEmail='" + customerIndividualEmail + '\'' +
                '}';
    }

    /**
     * customerIndividualId: 用户信息表ID
     */
    private Integer customerIndividualId;
    /**
     * loginId: 用户登录表ID
     */
    private Integer loginId;
    /**
     * customerIndividualName: 用户姓名
     */
    private String customerIndividualName;
    /**
     * customerIndividualGender: 用户性别
     *                              0:"男"
     *                              1:"女"
     */
    private Byte customerIndividualGender;
    /**
     * customerIndividualCard: 用户身份证号
     */
    private String customerIndividualCard;
    /**
     * customerIndividualPhone: 用户手机号
     */
    private String customerIndividualPhone;
    /**
     * customerIndividualEmail: 用户邮箱
     */
    private String customerIndividualEmail;
}
