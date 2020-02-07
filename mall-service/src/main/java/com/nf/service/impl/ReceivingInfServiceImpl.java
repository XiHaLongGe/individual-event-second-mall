package com.nf.service.impl;

import com.nf.dao.port.ReceivingInfDao;
import com.nf.entity.ReceivingInfEntity;
import com.nf.service.port.ReceivingInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfServiceImpl
 * @Date: 2020-02-06 15:50
 * @Description: 收货信息表service层
 */
@Service
public class ReceivingInfServiceImpl implements ReceivingInfService{
    @Autowired
    private ReceivingInfDao receivingInfDao;
    @Override
    public List<ReceivingInfEntity> getListByLoginId(Integer loginId) {
        return receivingInfDao.getListByLoginId(loginId);
    }

    @Override
    public ReceivingInfEntity getListByReceivingInfId(Integer receivingInfId) {
        return receivingInfDao.getListByReceivingInfId(receivingInfId);
    }

    @Override
    public boolean insertReceivingInf(ReceivingInfEntity receivingInfEntity) {
        return receivingInfDao.insertReceivingInf(receivingInfEntity) > 0;
    }

    @Override
    public boolean updateReceivingInf(ReceivingInfEntity receivingInfEntity) {
        return receivingInfDao.updateReceivingInf(receivingInfEntity) > 0;
    }

    @Override
    public boolean updateIsDefault(Integer receivingInfId) {
        return receivingInfDao.updateIsDefault(receivingInfId) > 0;
    }

    @Override
    public boolean updateNotDefault(Integer loginId) {
        return receivingInfDao.updateNotDefault(loginId) >= 0;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDefault(Integer receivingInfId, Integer loginId) {
        return updateNotDefault(loginId) && updateIsDefault(receivingInfId);
    }

    @Override
    public boolean deleteReceivingInf(Integer receivingInfId) {
        return receivingInfDao.deleteReceivingInf(receivingInfId) > 0;
    }
}
