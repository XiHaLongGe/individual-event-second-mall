package com.nf.dao.port;

import com.nf.entity.ReceivingInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ReceivingInfDao
 * @Date: 2020-02-06 15:39
 * @Description: 收货信息dao层接口
 */
public interface ReceivingInfDao {
    /**
     * 根据用户id获取所有收货信息
     * @param loginId 用户id
     * @return
     */
    List<ReceivingInfEntity> getListByLoginId(@Param("loginId") Integer loginId);

    /**
     * 根据收货信息id获取所有收货信息
     * @param receivingInfId 收货信息id
     * @return
     */
    ReceivingInfEntity getListByReceivingInfId(@Param("receivingInfId") Integer receivingInfId);

    /**
     * 添加收货信息
     * @param receivingInfEntity 收货信息实体类
     * @return
     */
    Integer insertReceivingInf(@Param("receivingInfEntity") ReceivingInfEntity receivingInfEntity);

    /**
     * 修改收货信息
     * @param receivingInfEntity 收货信息实体类
     * @return
     */
    Integer updateReceivingInf(@Param("receivingInfEntity") ReceivingInfEntity receivingInfEntity);

    /**
     * 根据收货信息id设为默认地址
     * @return
     */
    Integer updateIsDefault(@Param("receivingInfId") Integer receivingInfId);

    /**
     * 撤消用户id的默认地址，结合updateIsDefault使用
     * @return
     */
    Integer updateNotDefault(@Param("loginId") Integer loginId);

    /**
     * 删除收货信息
     * @param receivingInfId 收货信息id
     * @return
     */
    Integer deleteReceivingInf(@Param("receivingInfId") Integer receivingInfId);
}
