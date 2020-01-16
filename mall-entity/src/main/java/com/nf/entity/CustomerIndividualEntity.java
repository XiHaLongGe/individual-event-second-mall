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
    private CustomerIndividualEntity(Builder builder) {
        customerIndividualId = builder.customerIndividualId;
        loginId = builder.loginId;
        customerIndividualName = builder.customerIndividualName;
        customerIndividualGender = builder.customerIndividualGender;
        customerIndividualCard = builder.customerIndividualCard;
        customerIndividualPhone = builder.customerIndividualPhone;
        customerIndividualEmail = builder.customerIndividualEmail;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerIndividualEntity copy) {
        Builder builder = new Builder();
        builder.customerIndividualId = copy.getCustomerIndividualId();
        builder.loginId = copy.getLoginId();
        builder.customerIndividualName = copy.getCustomerIndividualName();
        builder.customerIndividualGender = copy.getCustomerIndividualGender();
        builder.customerIndividualCard = copy.getCustomerIndividualCard();
        builder.customerIndividualPhone = copy.getCustomerIndividualPhone();
        builder.customerIndividualEmail = copy.getCustomerIndividualEmail();
        return builder;
    }

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

    public static final class Builder {
        private Integer customerIndividualId;
        private Integer loginId;
        private String customerIndividualName;
        private Byte customerIndividualGender;
        private String customerIndividualCard;
        private String customerIndividualPhone;
        private String customerIndividualEmail;

        private Builder() {
        }

        public Builder customerIndividualId(Integer val) {
            customerIndividualId = val;
            return this;
        }

        public Builder loginId(Integer val) {
            loginId = val;
            return this;
        }

        public Builder customerIndividualName(String val) {
            customerIndividualName = val;
            return this;
        }

        public Builder customerIndividualGender(Byte val) {
            customerIndividualGender = val;
            return this;
        }

        public Builder customerIndividualCard(String val) {
            customerIndividualCard = val;
            return this;
        }

        public Builder customerIndividualPhone(String val) {
            customerIndividualPhone = val;
            return this;
        }

        public Builder customerIndividualEmail(String val) {
            customerIndividualEmail = val;
            return this;
        }

        public CustomerIndividualEntity build() {
            return new CustomerIndividualEntity(this);
        }
    }
}
