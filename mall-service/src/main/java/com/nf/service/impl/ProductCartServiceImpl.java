package com.nf.service.impl;

import com.nf.dao.port.ProductCartDao;
import com.nf.entity.ProductCartEntity;
import com.nf.service.port.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: LJP
 * @Classname ProductCartServiceImpl
 * @Date: 2020-02-07 11:59
 * @Description: 购物车service层
 */
@Service
public class ProductCartServiceImpl implements ProductCartService {
    @Autowired
    private ProductCartDao productCartDao;

    @Override
    public Integer getCountByLoginId(Integer loginId) {
        return productCartDao.getCountByLoginId(loginId);
    }

    @Override
    public ProductCartEntity getProductCart(ProductCartEntity productCartEntity) {
        return productCartDao.getProductCart(productCartEntity);
    }

    @Override
    public boolean updateProductNum(ProductCartEntity productCartEntity) {
        return productCartDao.updateProductNum(productCartEntity) > 0;
    }

    @Override
    public boolean insertProduct(ProductCartEntity productCartEntity) {
        return productCartDao.insertProduct(productCartEntity) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addCart(ProductCartEntity productCartEntity) {
        boolean result;
        /*先查询数据库中是否存在要添加的商品数据，如果存在则返回存在的商品数据*/
        ProductCartEntity productCartEntity1 = getProductCart(productCartEntity);
        if(productCartEntity1 != null){
            /*如果数据存在，则进行修改操作*/
            /*首先将数据库中该商品的数量加上传进来商品的数量*/
            Integer productNum = productCartEntity1.getProductCartNum() + productCartEntity.getProductCartNum();
            productCartEntity = ProductCartEntity.newBuilder(productCartEntity).productCartNum(productNum).build();
            result = updateProductNum(productCartEntity);
        }else{
            /*否则进行添加操作*/
            result = insertProduct(productCartEntity);
        }
         return result;
    }
}
