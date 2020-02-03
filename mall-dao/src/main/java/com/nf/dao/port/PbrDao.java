package com.nf.dao.port;

import com.nf.entity.ProCategoryBrandInfRelevanceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PbrDao
 * @Date: 2020-02-02 21:08
 * @Description: 商品类型与品牌信息关联表的dao层接口
 */
public interface PbrDao {
    /**
     * 根据商品类型品牌信息关联表id获得数据
     * @param pbrId 商品类型品牌信息关联表id
     * @return
     */
    ProCategoryBrandInfRelevanceEntity getByPbrId(@Param("pbrId") Integer pbrId);

    /**
     * 根据关联表id获得商品类型品牌信息数据
     * @param pbrIdArray 关联表id
     * @return
     */
    List<ProCategoryBrandInfRelevanceEntity> getListByPbrId(@Param("pbrIdArray") Integer[] pbrIdArray);

    /**
     * 通过商品类型id来获得在类型表中存在的条目数量
     * @param proCategoryIdArray 商品类型id
     * @return 条目数量
     */
    Integer getByProCategoryIdCount(String[] proCategoryIdArray);

    /**
     * 通过品牌信息id来获得在关联表中存在的条目数量
     * @param brandInfIdArray 品牌信息id
     * @return 条目数量
     */
    Integer getByBrandInfIdCount(@Param("brandInfIdArray") Integer[] brandInfIdArray);

    /**
     * 添加商品类型品牌信息关联表的数据
     * @param proCategoryBrandInfRelevanceEntity 添加的商品信息
     * @return 对数据库的影响行数
     */
    Integer insertPbr(@Param("proCategoryBrandInfRelevanceEntity") ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity);

    /**
     * 修改商品类型品牌信息关联表的数据
     * @param proCategoryBrandInfRelevanceEntity 修改的商品信息
     * @return 对数据库的影响行数
     */
    Integer updatePbr(@Param("proCategoryBrandInfRelevanceEntity") ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity);

    /**
     * 批量删除关联表中包含传入品牌信息id的数据
     * @param brandInfIdArray 接收品牌信息表id
     * @return 对数据库的影响行数
     */
    Integer batchDeleteByBrandInfId(@Param("brandInfIdArray") Integer [] brandInfIdArray);

    /**
     * 批量删除关联表信息
     * @param pbrIdArray 接收需要删除的关联表id
     * @return 返回对数据库的影响行数
     */
    Integer batchDeleteBrandInf(@Param("pbrIdArray")Integer [] pbrIdArray);
}
