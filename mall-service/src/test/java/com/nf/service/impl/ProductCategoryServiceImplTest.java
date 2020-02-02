package com.nf.service.impl;

import com.nf.config.AppConfig;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.ProductCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void insertProductCategory() {
        /*商品父栏目测试通过*/
        /*productCategoryService.insertProductCategory(ProductCategoryEntity.newBuilder()
                .productCategoryName("测试")
                .productCategoryLevel(1)
                .build());*/
        /*商品子栏目测试通过*/
        /*productCategoryService.insertProductCategory(ProductCategoryEntity.newBuilder()
                                                                                .productCategoryName("测试")
                                                                                .productCategoryLevel(2)
                                                                                .parentId("1-1")
                                                                            .build());*/
    }

    @Test
    public void getByParentId() {
        for (String s : productCategoryService.getByParentId(new String[]{"1-1", "1-2"})) {
            System.out.println(s);
        }
    }
}