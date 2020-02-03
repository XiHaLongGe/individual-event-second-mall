package com.nf.service.impl;

import com.nf.dao.port.ProductInfDao;
import com.nf.entity.ProductInfEntity;
import com.nf.service.port.ProductInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfServiceImpl
 * @Date: 2020-02-02 16:51
 * @Description: 商品信息表service层
 */
@Service
public class ProductInfServiceImpl implements ProductInfService {
    @Autowired
    private ProductInfDao productInfDao;

    @Override
    public List<ProductInfEntity> getPageByCondition(Integer pageNum, Integer pageSize, ProductInfEntity productInfEntity) {
        return productInfDao.getPageByCondition(pageNum, pageSize, productInfEntity);
    }
}
