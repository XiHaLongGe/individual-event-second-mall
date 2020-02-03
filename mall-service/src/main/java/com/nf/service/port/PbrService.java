package com.nf.service.port;

import com.nf.entity.BrandInfEntity;
import com.nf.entity.ProCategoryBrandInfRelevanceEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname PbrService
 * @Date: 2020-02-02 21:23
 * @Description: 商品类型与品牌信息关联表的service层接口
 */
public interface PbrService {
    /**
     * 根据商品类型品牌信息关联表id获得数据
     * @param pbrId 商品类型品牌信息关联表id
     * @return
     */
    ProCategoryBrandInfRelevanceEntity getByPbrId(Integer pbrId);

    /**
     * 根据条件查询关联表信息
     * @param pbrEntity 用来接收查询条件
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @return
     */
    List<ProCategoryBrandInfRelevanceEntity> getPageByCondition(Integer pageNum,
                                                                Integer pageSize,
                                                                ProCategoryBrandInfRelevanceEntity pbrEntity);

    /**
     * 根据关联表id获得商品类型品牌信息数据
     * @param pbrIdArray 关联表id
     * @return
     */
    List<ProCategoryBrandInfRelevanceEntity> getListByPbrId(Integer[] pbrIdArray);


    /**
     * 获取到关联表中所有的品牌信息id
     * @return
     */
    Integer[] getAllBrandInfId();


    /**
     * 获取到关联表中所有的商品类型id
     * @return
     */
    String[] getAllProCategoryId();

    /**
     * 通过商品类型id来获得在类型表中存在的条目数量
     * @param proCategoryIdArray 商品类型id
     * @return 条目数量
     */
    Integer getByProCategoryIdCount(String[] proCategoryIdArray);

    /**
     * 添加商品类型品牌信息关联表的数据
     * @param proCategoryBrandInfRelevanceEntity 添加的商品信息
     * @return 添加结果
     */
    boolean insertPbr(ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity);


    /**
     * 修改商品类型品牌信息关联表的数据
     * @param proCategoryBrandInfRelevanceEntity 修改的商品信息
     * @return 对数据库的影响行数
     */
    boolean updatePbr(ProCategoryBrandInfRelevanceEntity proCategoryBrandInfRelevanceEntity);


    /**
     * 批量删除关联表中包含传入品牌信息id的数据
     * @param brandInfId 接收品牌信息表id
     * @return 返回删除结果
     */
    boolean batchDeleteByBrandInfId(Integer [] brandInfId);


    /**
     * 批量删除关联表信息
     * @param pbrIdArray 接收需要删除的关联表id
     * @return 返回对数据库的影响行数
     */
    boolean batchDeleteBrandInf(Integer [] pbrIdArray);
}
