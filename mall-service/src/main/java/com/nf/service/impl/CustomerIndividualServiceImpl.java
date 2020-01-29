package com.nf.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.nf.dao.port.CustomerIndividualDao;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.service.port.CustomerIndividualService;
import com.nf.service.port.CustomerLoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private CustomerLoginService customerLoginService;

    @Override
    public List<CustomerIndividualEntity> getPageAll(Integer pageNum, Integer pageSize) {
        return customerIndividualDao.getPageAll(pageNum, pageSize);
    }

    @Override
    public List<CustomerIndividualEntity> getPageByCondition(Integer pageNum, Integer pageSize, CustomerIndividualEntity customerIndividualEntity) {
        return customerIndividualDao.getPageByCondition(pageNum, pageSize, customerIndividualEntity);
    }

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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCustomer(Integer loginId, boolean yn) {
        Integer number = customerIndividualDao.deleteCustomer(loginId);
        if(yn){
            customerLoginService.deleteCustomer(loginId, false);
        }
        return number > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchDeleteCustomer(String[] loginIdArray, boolean yn) {
        /*将字符串数组类型转换成Integer整数类型数组*/
        Integer [] loginIdArrays = new Integer[loginIdArray.length];
        for (int i = 0; i < loginIdArray.length; i++) {
            loginIdArrays[i] = Integer.valueOf(loginIdArray[i]);
        }
        /*获得批量删除对数据库的影响行数*/
        Integer number = customerIndividualDao.batchDeleteCustomer(loginIdArrays);
        if(yn){
            /*将用户登录表中该登录id的数据也删除*/
            customerLoginService.batchDeleteCustomer(loginIdArray, false);
        }
        return number == loginIdArray.length;
    }
}
