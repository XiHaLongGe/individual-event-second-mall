package com.nf.service.impl;

import com.nf.dao.port.ProductCategoryDao;
import com.nf.entity.ProductCategoryEntity;
import com.nf.service.port.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryServiceImpl
 * @Date: 2020-01-29 10:45
 * @Description: 商品类型表的service层
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategoryEntity> getPageByCondition(Integer pageNum, Integer pageSize, ProductCategoryEntity productCategoryEntity) {
        return productCategoryDao.getPageByCondition(pageNum, pageSize, productCategoryEntity);
    }

    @Override
    public List<ProductCategoryEntity> getByProductCategoryLevel(Integer productCategoryLevel) {
        return productCategoryDao.getByProductCategoryLevel(productCategoryLevel);
    }

    @Override
    public boolean insertProductCategory(ProductCategoryEntity productCategoryEntity) {
        return productCategoryDao.insertProductCategory(productCategoryEntity) > 0;
    }
}
