package com.nf.service.impl;

import com.nf.config.AppConfig;
import com.nf.entity.CustomerLoginEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
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
        System.out.println(customerLoginService.verifyLogin(CustomerLoginEntity.newBuilder().loginAccount("18546320231").loginPassword("96e79218965eb72c92a549dd5a330112").build()));
    }
}