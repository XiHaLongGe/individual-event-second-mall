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
    public List<BrandInfEntity> getExistData(Integer[] brandInfIdArray) {
        return brandInfDao.getExistData(brandInfIdArray);
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
        return brandInfDao.updateBrandInf(brandInfEntity) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchDeleteBrandInf(Integer[] brandInfIdArray, boolean cascadeDelete) {
        //删除在关联表中存在传入品牌id的数据
        boolean result = pbrService.batchDeleteByBrandInfId(brandInfIdArray);
        return result && brandInfDao.batchDeleteBrandInf(brandInfIdArray) == brandInfIdArray.length;
    }
}
