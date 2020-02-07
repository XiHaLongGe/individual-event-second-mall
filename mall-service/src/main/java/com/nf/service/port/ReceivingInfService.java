package com.nf.service.port;

import com.nf.entity.ReceivingInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfService
 * @Date: 2020-02-06 15:49
 * @Description: 收货信息表service层接口
 */
public interface ReceivingInfService {

    /**
     * 根据用户id获取所有收货信息
     * @param loginId 用户id
     * @return
     */
    List<ReceivingInfEntity> getListByLoginId(Integer loginId);

    /**
     * 根据收货信息id获取所有收货信息
     * @param receivingInfId 收货信息id
     * @return
     */
    ReceivingInfEntity getListByReceivingInfId(Integer receivingInfId);


    /**
     * 添加收货信息
     * @param receivingInfEntity 收货信息实体类
     * @return
     */
    boolean insertReceivingInf(ReceivingInfEntity receivingInfEntity);

    /**
     * 修改收货信息
     * @param receivingInfEntity 收货信息实体类
     * @return
     */
    boolean updateReceivingInf(ReceivingInfEntity receivingInfEntity);


    /**
     * 根据收货信息id设为默认地址
     * @return
     */
    boolean updateIsDefault(Integer receivingInfId);

    /**
     * 撤消用户id的默认地址，结合updateIsDefault使用
     * @return
     */
    boolean updateNotDefault(Integer loginId);

    /**
     * 结合 撤消/设置默认地址的方法使用
     * @param receivingInfId 收货信息id
     * @param loginId 登录id
     * @return
     */
    boolean updateDefault(Integer receivingInfId, Integer loginId);


    /**
     * 删除收货信息
     * @param receivingInfId 收货信息id
     * @return
     */
    boolean deleteReceivingInf(Integer receivingInfId);
}
