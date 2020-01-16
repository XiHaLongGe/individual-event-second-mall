package com.nf.service.impl;

import com.nf.dao.port.CustomerIndividualDao;
import com.nf.dao.port.CustomerLoginDao;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
import com.nf.util.Md5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private CustomerIndividualDao customerIndividualDao;
    @Override
    public boolean verifyLogin(CustomerLoginEntity customerLoginEntity) {
        /*对明文密码进行加密操作*/
        String pwd = Md5Util.encodeByMd5(customerLoginEntity.getLoginPassword());
        return customerLoginDao.verifyLogin(CustomerLoginEntity.newBuilder(customerLoginEntity).loginPassword(pwd).build());
    }

    @Override
    public boolean registerCustomer(CustomerLoginEntity customerLoginEntity) {
        //获取到CustomerIndividualEntity个人信息表的实体类对象实例
        CustomerIndividualEntity customerIndividualEntity = CustomerIndividualEntity.newBuilder().build();
        if(customerLoginDao.registerCustomer(customerLoginEntity) > 0){
            //通过BeanUtils工具类将属性相同的值进行复制，
            //这里就是将CustomerLoginEntity类中的扩展字段中的数据复制到用户信息表的实体类中
            BeanUtils.copyProperties(customerLoginEntity,customerIndividualEntity);
            if(customerIndividualDao.insertIndividual(customerIndividualEntity) > 0){
                return true;
            }
        }
        return false;
    }
}
