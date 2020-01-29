package com.nf.service.impl;


import com.nf.config.AppConfig;
import com.nf.entity.CustomerIndividualEntity;
import com.nf.service.port.CustomerIndividualService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerIndividualServiceImplTest {
    @Autowired
    private CustomerIndividualService customerIndividualService;
    @Test
    public void getPageByCondition() {
        for (CustomerIndividualEntity customerIndividualEntity : customerIndividualService.getPageByCondition(1, 5, CustomerIndividualEntity.newBuilder().startBirth("2000-10-10").endBirth("2007-10-10").customerIndividualName("李").customerIndividualGender(Byte.valueOf("1")).build())) {
            System.out.println(customerIndividualEntity);
        }
    }
}
