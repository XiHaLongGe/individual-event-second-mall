package com.nf.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.nf.dao.port.BrandInfDao;
import com.nf.dao.port.PbrDao;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProCategoryBrandInfRelevanceEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.PbrService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfServiceImpl
 * @Date: 2020-01-31 19:10
 * @Description: 品牌信息service层
 */
@Service
public class BrandInfServiceImpl implements BrandInfService {
    @Autowired
    private BrandInfDao brandInfDao;
    @Autowired
    private PbrService pbrService;

    @Override
    public List<BrandInfEntity> getAllData() {
        return brandInfDao.getAllData();
    }

    @Override
    public List<BrandInfEntity> getPageByCondition(Integer pageNum, Integer pageSize, BrandInfEntity brandInfEntity) {
        return brandInfDao.getPageByCondition(pageNum, pageSize, brandInfEntity);
    }

    @Override
    public List<BrandInfEntity> getExistPbrData() {
        //获取到关联表中所有的品牌信息id
        Integer[] brandInfIdArray = pbrService.getAllBrandInfId();
        return brandInfDao.getExistPbrData(brandInfIdArray);
    }

    @Override
    public BrandInfEntity getByBrandInfId(Integer brandInfId) {
        return brandInfDao.getByBrandInfId(brandInfId);
    }

    @Override
    public boolean insertBrandInf(BrandInfEntity brandInfEntity) {
        return brandInfDao.insertBrandInf(brandInfEntity) > 0;
    }

    @Override
    public boolean updateBrandInf(BrandInfEntity brandInfEntity) {
        /*获取到一个商品类型与品牌信息关联表实体类实例*//*
        ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity = ProCategoryBrandInfRelevanceEntity.newBuilder().build();
        *//*通过BeanUtils工具类对相同字段进行复制赋值操作*//*
        BeanUtils.copyProperties(brandInfEntity, proCategoryBrandInfRelevanceEntity);
        *//*得到商品类型与品牌信息关联表的修改结果*//*
        boolean result = pbrService.updatePbr(proCategoryBrandInfRelevanceEntity);
        *//*获取到要修改的品牌id*//*
        Integer brandInfId = pbrService.getByPbrId(brandInfEntity.getPbrId()).getBrandInfId();
        *//*将获取到的品牌id传入实体类*//*
        brandInfEntity.setBrandInfId(brandInfId);*/
        return /*result && */brandInfDao.updateBrandInf(brandInfEntity) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchDeleteBrandInf(Integer[] brandInfIdArray, boolean cascadeDelete) {
        //删除在关联表中存在传入品牌id的数据
        boolean result = pbrService.batchDeleteByBrandInfId(brandInfIdArray);
        return result && brandInfDao.batchDeleteBrandInf(brandInfIdArray) == brandInfIdArray.length;
    }
}
