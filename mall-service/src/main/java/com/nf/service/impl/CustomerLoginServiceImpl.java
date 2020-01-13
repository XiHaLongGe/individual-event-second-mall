package com.nf.service.impl;

import com.nf.dao.port.CustomerLoginDao;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
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
        return customerLoginDao.verifyLogin(customerLoginEntity);
    }
}
