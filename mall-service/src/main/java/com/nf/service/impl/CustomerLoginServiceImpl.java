package com.nf.service.impl;

import com.nf.dao.port.CustomerIndividualDao;
import com.nf.dao.port.CustomerLoginDao;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerIndividualService;
import com.nf.service.port.CustomerLoginService;
import com.nf.util.CodeUtil;
import com.nf.util.MailUtil;
import com.nf.util.Md5Util;
import com.nf.util.RandomCodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: LJP
 * @Classname CustomerLoginServiceImpl
 * @Date: 2020-01-12 21:45
 * @Description: 用户登录的service层
 */
@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Autowired
    private CustomerLoginDao customerLoginDao;
    @Autowired
    private CustomerIndividualService customerIndividualService;

    @Override
    public CustomerLoginEntity getByLoginId(Integer loginId) {
        return customerLoginDao.getByLoginId(loginId);
    }

    @Override
    public CustomerLoginEntity getByLoginAccount(String loginAccount) {
        return customerLoginDao.getByLoginAccount(loginAccount);
    }

    @Override
    public boolean verifyLogin(CustomerLoginEntity customerLoginEntity) {
        /*对明文密码进行加密操作*/
        String pwd = Md5Util.encodeByMd5(customerLoginEntity.getLoginPassword());
        //将加密后的密码覆盖明文密码
        customerLoginEntity.setLoginPassword(pwd);
        return customerLoginDao.verifyLogin(customerLoginEntity);
    }

    @Override
    public boolean equalsPassword(Integer loginId, String frontPassword) {
        /*对明文密码进行加密操作*/
        frontPassword = Md5Util.encodeByMd5(frontPassword);
        return customerLoginDao.equalsPassword(loginId, frontPassword);
    }

    @Override
    public boolean updatePassword(Integer loginId, String password) {
        /*对明文密码进行加密操作*/
        password = Md5Util.encodeByMd5(password);
        return customerLoginDao.updatePassword(loginId, password) > 0;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean registerCustomer(CustomerLoginEntity customerLoginEntity) {
        //获取到用户填入邮箱
        String emailStr = customerLoginEntity.getCustomerIndividualEmail();
        //对用户填入的密码进行加密
        String loginPassword = Md5Util.encodeByMd5(customerLoginEntity.getLoginPassword());
        //生成一个11位长度的帐号
        String loginAccount = RandomCodeUtil.randomGenerate();
        //生成帐号激活码
        String activateCode = CodeUtil.generateUniqueCode();
        //获取到CustomerIndividualEntity个人信息表的实体类对象实例
        CustomerIndividualEntity customerIndividualEntity = CustomerIndividualEntity.newBuilder().build();
        //下面将系统生成的账号、帐号激活码...添加至实体类中
        CustomerLoginEntity enhanceEntity = CustomerLoginEntity.newBuilder(customerLoginEntity)
                                                                    .loginPassword(loginPassword)
                                                                    .loginAccount(loginAccount)
                                                                    .activateCode(activateCode)
                                                                .build();
        if(customerLoginDao.registerCustomer(enhanceEntity) > 0){
            //通过BeanUtils工具类将属性相同的值进行复制，
            //这里就是将CustomerLoginEntity类中的扩展字段中的数据复制到用户信息表的实体类中
            BeanUtils.copyProperties(enhanceEntity,customerIndividualEntity);
            //这里将保存着处理完数据的实体类中的数据复制到传入进来的实体类中
            BeanUtils.copyProperties(enhanceEntity,customerLoginEntity);
            //将个人信息添加到用户信息表
            if(customerIndividualService.insertIndividual(customerIndividualEntity)){
                //这里发送激活帐号的邮件给用户填入的邮箱
                new Thread(new MailUtil(emailStr, activateCode)).start();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePersonal(CustomerLoginEntity customerLoginEntity) {
        return customerLoginDao.updatePersonal(customerLoginEntity) > 0;
    }

    @Override
    public boolean updateAccountStats(CustomerLoginEntity customerLoginEntity) {
        return customerLoginDao.updateAccountStats(customerLoginEntity) > 0;
    }
}
