package com.nf.service.impl;

import com.nf.config.AppConfig;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.entity.CustomerLoginEntity;
import com.nf.service.port.CustomerLoginService;
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
    private CustomerLoginService customerLoginService;
    @Test
    public void verifyLogin() {
        System.out.println(customerLoginService.verifyLogin(CustomerLoginEntity.newBuilder().loginAccount("18546320231").loginPassword("111111").build()));
    }

    @Test
    public void registerCustomer() {
        CustomerLoginEntity customerLoginEntity = CustomerLoginEntity.newBuilder()
                                                                            .loginName("123")
                                                                            .loginPassword("111111")
                                                                            .customerIndividualPhone("18738475647")
                                                                            .customerIndividualEmail("")
                                                                        .build();
        customerLoginService.registerCustomer(customerLoginEntity);
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

    @Test
    public void updateAccountStats() {
        System.out.println(customerLoginService.updateAccountStats(CustomerLoginEntity.newBuilder()
                                                                                            .activateCode("42fa4af762b843dca0393605a1feba30")
                                                                                            .accountStats(Byte.valueOf("1"))
                                                                                        .build()));
    }
}