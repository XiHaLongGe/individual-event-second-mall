package com.nf.service.impl;

import com.nf.config.AppConfig;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.entity.CustomerLoginEntity;
import com.nf.util.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerLoginServiceImplTest {
    @Autowired
    private CustomerLoginServiceImpl customerLoginService;
    @Test
    public void verifyLogin() {
        System.out.println(customerLoginService.verifyLogin(CustomerLoginEntity.newBuilder().loginAccount("18546320231").loginPassword(Md5Util.encodeByMd5("111111")).build()));
    }

    @Test
    public void registerCustomer() {
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder().loginName("123").loginAccount("12345678901").loginPassword(Md5Util.encodeByMd5("111111")).accountStats(Byte.valueOf("0")).build();
        System.out.println(customerLoginEntity.getLoginId());
        System.out.println("///////////////////////一开始没有为login_id字段赋值//////////////////////////////");
        System.out.println("影响行数：" + customerLoginService.registerCustomer(customerLoginEntity));
        System.out.println("///////////////////////添加成功后在mapper文件中将自增id的值赋给login_id字段，如下取出赋值id//////////////////////////////");
        System.out.println(customerLoginEntity.getLoginId());
    }
    @Test
    public void BeanUtilsTest(){
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder().loginId(1).build();
        CustomerIndividualEntity customerIndividualEntity = CustomerIndividualEntity.newBuilder().build();
        System.out.println("customerLoginEntity" + customerLoginEntity);
        System.out.println("customerIndividualEntity" + customerIndividualEntity);

        BeanUtils.copyProperties(customerLoginEntity, customerIndividualEntity);

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-");

        System.out.println("customerLoginEntity" + customerLoginEntity);
        System.out.println("customerIndividualEntity" + customerIndividualEntity);
    }
}