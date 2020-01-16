package com.nf.service.impl;

import com.nf.dao.port.CustomerIndividualDao;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.service.port.CustomerIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LJP
 * @Classname CustomerIndividualServiceImpl
 * @Date: 2020-01-16 10:35
 * @Description:
 */
@Service
public class CustomerIndividualServiceImpl implements CustomerIndividualService {
    @Autowired
    private CustomerIndividualDao customerIndividualDao;
    /*@Override
    public boolean insertIndividual(CustomerIndividualEntity customerIndividualEntity) {
        return customerIndividualDao.insertIndividual(customerIndividualEntity) > 0;
    }*/
}
