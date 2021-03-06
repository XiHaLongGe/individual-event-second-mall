package com.nf.service.port;

import com.nf.entity.BrandInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfService
 * @Date: 2020-01-31 19:09
 * @Description: 品牌信息表service层接口
 */
public interface BrandInfService {
    /**
     * 获取所有品牌信息
     * @return
     */
    List<BrandInfEntity> getAllData();

    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param brandInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<BrandInfEntity> getPageByCondition(Integer pageNum,
                                            Integer pageSize,
                                            BrandInfEntity brandInfEntity);

    /**
     * 根据商品名称获取相对应的品牌信息
     * @param productInfName 商品名称
     * @return
     */
    List<BrandInfEntity> getBelongByProductInfName(String productInfName);

    /**
     * 根据品牌信息id获得列表数据
     * @param brandInfIdArray 用来接收品牌信息id
     * @return
     */
    List<BrandInfEntity> getExistData(Integer[] brandInfIdArray);

    /**
     * 根据品牌信息id来获取品牌信息数据
     * @param brandInfId 用来接收品牌信息id
     * @return
     */
    BrandInfEntity getByBrandInfId(Integer brandInfId);

    /**
     * 添加品牌信息数据
     * @param brandInfEntity 用来接收添加的品牌信息数据
     * @return 添加结果
     */
    boolean insertBrandInf(BrandInfEntity brandInfEntity);

    /**
     * 修改品牌信息数据
     * @param brandInfEntity 用来接收添加的品牌信息数据
     * @return 修改结果
     */
    boolean updateBrandInf(BrandInfEntity brandInfEntity);


    /**
     * 批量删除品牌信息
     * @param brandInfIdArray 接收需要删除的品牌信息id
     * @param cascadeDelete 用来确定是否需要对关联表的相关数据进行删除操作(商品信息表)
     * @return 删除结果
     */
    boolean batchDeleteBrandInf(Integer [] brandInfIdArray, boolean cascadeDelete);
}
