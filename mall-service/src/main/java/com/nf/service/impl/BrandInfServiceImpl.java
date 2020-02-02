package com.nf.service.impl;

import com.nf.dao.port.BrandInfDao;
import com.nf.entity.BrandInfEntity;
import com.nf.service.port.BrandInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<BrandInfEntity> getPageByCondition(Integer pageNum, Integer pageSize, BrandInfEntity brandInfEntity) {
        return brandInfDao.getPageByCondition(pageNum, pageSize, brandInfEntity);
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

    @Override
    public boolean batchDeleteBrandInf(String[] brandInfIdArray, boolean cascadeDelete) {
        /*将字符串数组类型转换成Integer整数类型数组*/
        Integer [] brandInfIdArrays = new Integer[brandInfIdArray.length];
        for (int i = 0; i < brandInfIdArray.length; i++) {
            brandInfIdArrays[i] = Integer.valueOf(brandInfIdArray[i]);
        }
        return brandInfDao.batchDeleteBrandInf(brandInfIdArrays) == brandInfIdArray.length;
    }
}
