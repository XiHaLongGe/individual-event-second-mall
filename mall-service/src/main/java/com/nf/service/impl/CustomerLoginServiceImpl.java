package com.nf.service.impl;

import com.nf.dao.port.CustomerLoginDao;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
import com.nf.util.Md5Util;
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
    @Override
    public boolean verifyLogin(CustomerLoginEntity customerLoginEntity) {
        /*对明文密码进行加密操作*/
        String pwd = Md5Util.encodeByMd5(customerLoginEntity.getLoginPassword());
        return customerLoginDao.verifyLogin(CustomerLoginEntity.newBuilder(customerLoginEntity).loginPassword(pwd).build());
    }

    @Override
    public Integer insertCustomer(CustomerLoginEntity customerLoginEntity) {
        return customerLoginDao.insertCustomer(customerLoginEntity);
    }
}
