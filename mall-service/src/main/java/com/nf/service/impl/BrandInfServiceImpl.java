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
}
