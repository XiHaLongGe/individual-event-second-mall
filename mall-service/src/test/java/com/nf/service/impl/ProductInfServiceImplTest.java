package com.nf.service.impl;

import com.nf.config.AppConfig;
import com.nf.entity.ProductCategoryEntity;
import com.nf.entity.ProductInfEntity;
import com.nf.service.port.ProductCategoryService;
import com.nf.service.port.ProductInfService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductInfServiceImplTest {
    @Autowired
    private ProductInfService productInfService;
    @Test
    public void getPageByCondition() {
        for (ProductInfEntity productCategoryEntity : productInfService.getPageByCondition(2,2,
                ProductInfEntity.newBuilder()
                            .productCategoryId(".")
                        .build()
        )) {
            System.out.println(productCategoryEntity);
        }
    }
}