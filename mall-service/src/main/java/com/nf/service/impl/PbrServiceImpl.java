package com.nf.service.impl;

import com.nf.dao.port.PbrDao;
import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProCategoryBrandInfRelevanceEntity;
import com.nf.service.port.BrandInfService;
import com.nf.service.port.PbrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PbrServiceImpl
 * @Date: 2020-02-02 21:24
 * @Description: 商品类型与品牌信息关联表的service层
 */
@Service
public class PbrServiceImpl implements PbrService {
    @Autowired
    private PbrDao pbrDao;

    @Override
    public ProCategoryBrandInfRelevanceEntity getByPbrId(Integer pbrId) {
        return pbrDao.getByPbrId(pbrId);
    }

    @Override
    public List<ProCategoryBrandInfRelevanceEntity> getPageByCondition(Integer pageNum,
                                                                       Integer pageSize,
                                                                       ProCategoryBrandInfRelevanceEntity pbrEntity) {
        return pbrDao.getPageByCondition(pageNum, pageSize, pbrEntity);
    }

    @Override
    public List<ProCategoryBrandInfRelevanceEntity> getListByPbrId(Integer[] pbrIdArray) {
        return pbrDao.getListByPbrId(pbrIdArray);
    }

    @Override
    public Integer[] getBrandInfIdByParenId(String[] proCategoryIdArray) {
        return pbrDao.getBrandInfIdByParenId(proCategoryIdArray);
    }

    @Override
    public Integer[] getAllBrandInfId() {
        return pbrDao.getAllBrandInfId();
    }

    @Override
    public String[] getAllProCategoryId() {
        return pbrDao.getAllProCategoryId();
    }

    @Override
    public Integer getByProCategoryIdCount(String[] proCategoryIdArray) {
        return pbrDao.getByProCategoryIdCount(proCategoryIdArray);
    }

    @Override
    public boolean insertPbr(ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity) {
        return pbrDao.insertPbr(proCategoryBrandInfRelevanceEntity) > 0;
    }

    @Override
    public boolean updatePbr(ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity) {
        return pbrDao.updatePbr(proCategoryBrandInfRelevanceEntity) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchDeleteByBrandInfId(Integer[] brandInfId) {
        //获取到品牌信息在关联表中的条目
        Integer brandInfCount = pbrDao.getByBrandInfIdCount(brandInfId);
        //根据获得到的品牌信息条目，来验证删除是否成功
        return pbrDao.batchDeleteByBrandInfId(brandInfId) == brandInfCount;
    }

    @Override
    public boolean batchDeletePbr(Integer[] pbrIdArray) {
        return pbrDao.batchDeletePbr(pbrIdArray) == pbrIdArray.length;
    }
}
