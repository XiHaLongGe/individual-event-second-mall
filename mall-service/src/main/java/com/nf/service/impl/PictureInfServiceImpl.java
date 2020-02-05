package com.nf.service.impl;

import com.nf.dao.port.PictureInfDao;
import com.nf.entity.PictureInfEntity;
import com.nf.service.port.PictureInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PictureInfServiceImpl
 * @Date: 2020-02-05 10:23
 * @Description: 图片信息表的service层
 */
@Service
public class PictureInfServiceImpl implements PictureInfService {
    @Autowired
    private PictureInfDao pictureInfDao;
    @Override
    public List<PictureInfEntity> getByProInf(PictureInfEntity pictureInfEntity) {
        return pictureInfDao.getByProInf(pictureInfEntity);
    }

    @Override
    public Integer[] getMasterByProInfId(Integer productInfId, boolean isMaster) {
        return pictureInfDao.getMasterByProInfId(productInfId, isMaster);
    }

    @Override
    public Integer batchInsert(PictureInfEntity pictureInfEntity) {
        return pictureInfDao.batchInsert(pictureInfEntity);
    }

    @Override
    public Integer batchUpdate(PictureInfEntity pictureInfEntity) {
        return pictureInfDao.batchUpdate(pictureInfEntity);
    }
}
