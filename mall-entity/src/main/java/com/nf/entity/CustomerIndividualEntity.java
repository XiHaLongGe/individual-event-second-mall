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


    /*===================================   扩展字段   begin   ==================================*/

    //以下扩展字段是用来接收前台传输过来的用户登录信息
    /**
     * headIconUrl: 头像路径
     */
    private String headIconUrl;
    /**
     * loginName: 昵称
     */
    private String loginName;
    //以下扩展字段是用来接收后台 用户信息界面中出生年月日的查询条件，根据该条件来获取时间段中用户的信息
    /**
     * startBirth: 出生年月日开始
     */
    private String startBirth;
    /**
     * endBirth: 出生年月日结束
     */
    private String endBirth;

    /*===================================   扩展字段   end   ==================================*/

    private CustomerIndividualEntity(Builder builder) {
        customerIndividualId = builder.customerIndividualId;
        loginId = builder.loginId;
        customerIndividualName = builder.customerIndividualName;
        customerIndividualGender = builder.customerIndividualGender;
        customerIndividualCard = builder.customerIndividualCard;
        customerIndividualPhone = builder.customerIndividualPhone;
        customerIndividualEmail = builder.customerIndividualEmail;
        headIconUrl = builder.headIconUrl;
        loginName = builder.loginName;
        startBirth = builder.startBirth;
        endBirth = builder.endBirth;
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
        builder.headIconUrl = copy.getHeadIconUrl();
        builder.loginName = copy.getLoginName();
        builder.startBirth = copy.getStartBirth();
        builder.endBirth = copy.getEndBirth();
        return builder;
    }

    public static final class Builder {
        private Integer customerIndividualId;
        private Integer loginId;
        private String customerIndividualName;
        private Byte customerIndividualGender;
        private String customerIndividualCard;
        private String customerIndividualPhone;
        private String customerIndividualEmail;
        private String headIconUrl;
        private String loginName;
        private String startBirth;
        private String endBirth;

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

        public Builder headIconUrl(String val) {
            headIconUrl = val;
            return this;
        }

        public Builder loginName(String val) {
            loginName = val;
            return this;
        }

        public Builder startBirth(String val) {
            startBirth = val;
            return this;
        }

        public Builder endBirth(String val) {
            endBirth = val;
            return this;
        }

        public CustomerIndividualEntity build() {
            return new CustomerIndividualEntity(this);
        }
    }
}
