package com.nf.service.impl;

import com.nf.dao.port.CustomerIndividualDao;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.service.port.CustomerIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LJP
 * @Classname CustomerIndividualServiceImpl
 * @Date: 2020-01-20 08:23
 * @Description: 用户信息表的service层
 */
@Service
public class CustomerIndividualServiceImpl implements CustomerIndividualService {
    @Autowired
    private CustomerIndividualDao customerIndividualDao;

    @Override
    public CustomerIndividualEntity getByLoginId(Integer loginId) {
        return customerIndividualDao.getByLoginId(loginId);
    }

    @Override
    public boolean insertIndividual(CustomerIndividualEntity customerIndividualEntity) {
        return customerIndividualDao.insertIndividual(customerIndividualEntity) > 0;
    }

    @Override
    public boolean updateCustomer(CustomerIndividualEntity customerIndividualEntity) {
        return customerIndividualDao.updateCustomer(customerIndividualEntity) > 0;
    }
}
