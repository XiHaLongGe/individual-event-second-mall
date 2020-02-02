package com.nf.dao.port;

import com.nf.entity.BrandInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfDao
 * @Date: 2020-01-31 18:53
 * @Description: 品牌信息表的dao层接口
 */
public interface BrandInfDao {

    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param brandInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<BrandInfEntity> getPageByCondition(@Param("pageNum") Integer pageNum,
                                            @Param("pageSize") Integer pageSize,
                                            @Param("brandInfEntity") BrandInfEntity brandInfEntity);

    /**
     * 根据品牌信息id来获取品牌信息数据
     * @param brandInfId 用来接收品牌信息id
     * @return
     */
    BrandInfEntity getByBrandInfId(@Param("brandInfId") Integer brandInfId);

    /**
     * 添加品牌信息数据
     * @param brandInfEntity 用来接收添加的品牌信息数据
     * @return 对数据库的影响行数
     */
    Integer insertBrandInf(@Param("brandInfEntity") BrandInfEntity brandInfEntity);

    /**
     * 修改品牌信息数据
     * @param brandInfEntity 用来接收添加的品牌信息数据
     * @return 对数据库的影响行数
     */
    Integer updateBrandInf(@Param("brandInfEntity") BrandInfEntity brandInfEntity);

    /**
     * 根据商品类型id对品牌信息进行删除
     * @param productCategoryIdArray 用来接收商品类型id
     * @return 对数据库的影响行数
     */
    Integer deleteByProductCategoryId(@Param("productCategoryIdArray")String[] productCategoryIdArray);

    /**
     * 批量删除品牌信息
     * @param brandInfIdArray 接收需要删除的品牌信息id
     * @return 返回对数据库的影响行数
     */
    Integer batchDeleteBrandInf(@Param("brandInfIdArray")Integer [] brandInfIdArray);
}
