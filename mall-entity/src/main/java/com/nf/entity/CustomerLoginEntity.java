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
    private CustomerLoginEntity(Builder builder) {
        loginId = builder.loginId;
        headIconUrl = builder.headIconUrl;
        loginName = builder.loginName;
        loginAccount = builder.loginAccount;
        loginPassword = builder.loginPassword;
        activateCode = builder.activateCode;
        accountStats = builder.accountStats;
        webmaster = builder.webmaster;
        customerIndividualPhone = builder.customerIndividualPhone;
        customerIndividualEmail = builder.customerIndividualEmail;
    }

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
                ", webmaster=" + webmaster +
                ", customerIndividualPhone='" + customerIndividualPhone + '\'' +
                ", customerIndividualEmail='" + customerIndividualEmail + '\'' +
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
     * accountStats: 管理员身份
     *              0:"否"
     *              1:"是"
     */
    private Byte webmaster;


    /*===================================   扩展字段   begin   ==================================*/

    //以下扩展字段是用来暂存用户信息
    /**
     * customerIndividualPhone: 用户手机号
     */
    private String customerIndividualPhone;
    /**
     * customerIndividualEmail: 用户邮箱
     */
    private String customerIndividualEmail;

    /*===================================   扩展字段   end   ==================================*/


    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(CustomerLoginEntity copy) {
        Builder builder = new Builder();
        builder.loginId = copy.getLoginId();
        builder.headIconUrl = copy.getHeadIconUrl();
        builder.loginName = copy.getLoginName();
        builder.loginAccount = copy.getLoginAccount();
        builder.loginPassword = copy.getLoginPassword();
        builder.activateCode = copy.getActivateCode();
        builder.accountStats = copy.getAccountStats();
        builder.webmaster = copy.getWebmaster();
        builder.customerIndividualPhone = copy.getCustomerIndividualPhone();
        builder.customerIndividualEmail = copy.getCustomerIndividualEmail();
        return builder;
    }
    public static final class Builder {
        private Integer loginId;
        private String headIconUrl;
        private String loginName;
        private String loginAccount;
        private String loginPassword;
        private String activateCode;
        private Byte accountStats;
        private Byte webmaster;
        private String customerIndividualPhone;
        private String customerIndividualEmail;

        private Builder() {
        }

        public Builder loginId(Integer val) {
            loginId = val;
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

        public Builder loginAccount(String val) {
            loginAccount = val;
            return this;
        }

        public Builder loginPassword(String val) {
            loginPassword = val;
            return this;
        }

        public Builder activateCode(String val) {
            activateCode = val;
            return this;
        }

        public Builder accountStats(Byte val) {
            accountStats = val;
            return this;
        }

        public Builder webmaster(Byte val) {
            webmaster = val;
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

        public CustomerLoginEntity build() {
            return new CustomerLoginEntity(this);
        }
    }

}
