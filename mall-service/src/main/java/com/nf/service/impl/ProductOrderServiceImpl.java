package com.nf.service.impl;

import com.nf.dao.port.ProductOrderDao;
import com.nf.entity.ProductCartEntity;
import com.nf.entity.ProductOrderEntity;
import com.nf.entity.ReceivingInfEntity;
import com.nf.service.port.ProductCartService;
import com.nf.service.port.ProductOrderService;
import com.nf.util.RandomCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductOrderServiceImpl
 * @Date: 2020-02-08 08:14
 * @Description: 商品信息service层
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductOrderDao productOrderDao;
    @Autowired
    private ProductCartService productCartService;

    @Override
    public ReceivingInfEntity getReceivingData(String productOrderNumber) {
        return productOrderDao.getReceivingData(productOrderNumber);
    }

    @Override
    public List<ProductOrderEntity> getCategoryListData(Integer loginId, Integer state) {
        return productOrderDao.getCategoryListData(loginId, state);
    }

    @Override
    public Integer getCategoryCountData(Integer loginId, Integer state) {
        return productOrderDao.getCategoryCountData(loginId, state);
    }

    @Override
    public List<ProductOrderEntity> getSubmitData(String productOrderNumber) {
        return productOrderDao.getSubmitData(productOrderNumber);
    }

    @Override
    public String insertSingleProductOrder(ProductCartEntity productCartEntity) {
        //获取长度为18的随机订单编号
        String productOrderNumber = RandomCodeUtil.randomGenerate(18);
        return productOrderDao.insertSingleProductOrder(productCartEntity, productOrderNumber) > 0 ? productOrderNumber : "";
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String insertCartProductOrder(List<ProductCartEntity> productCartEntity) {
        boolean result = productCartService.deleteByProductList(productCartEntity);
        //获取长度为18的随机订单编号
        String productOrderNumber = RandomCodeUtil.randomGenerate(18);
        /*操作成功返回订单编号*/
        return (result && productOrderDao.insertCartProductOrder(productCartEntity, productOrderNumber) > 0) ? productOrderNumber : "";
    }

    @Override
    public boolean submitOrder(ProductOrderEntity productOrderEntity) {
        return productOrderDao.submitOrder(productOrderEntity) > 0;
    }

    @Override
    public boolean paymentOrder(String productOrderNumber) {
        return productOrderDao.paymentOrder(productOrderNumber) > 0;
    }

    @Override
    public boolean confirmReceipt(String productOrderNumber) {
        return productOrderDao.confirmReceipt(productOrderNumber) > 0;
    }

    @Override
    public boolean deleteOrder(String productOrderNumber) {
        return productOrderDao.deleteOrder(productOrderNumber) > 0;
    }
}
