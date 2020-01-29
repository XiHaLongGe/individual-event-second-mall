package com.nf.dao.port;

import com.nf.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryDao
 * @Date: 2020-01-29 09:53
 * @Description: 商品类型表dao层接口
 */
public interface ProductCategoryDao {
    /**
     * 根据查询条件来获取到商品类型信息
     * @param pageNum 接收当前页码
     * @param pageSize 每页显示数据条目
     * @param productCategoryEntity 用来接收查询条件
     * @return 商品类型信息列表
     */
    List<ProductCategoryEntity> getPageByCondition(@Param("pageNum") Integer pageNum,
                                                   @Param("pageSize") Integer pageSize,
                                                   @Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    /**
     * 根据商品类型层级来获取到商品类型信息
     * @param productCategoryLevel 商品类型层级
     * @return
     */
    List<ProductCategoryEntity> getByProductCategoryLevel(@Param("productCategoryLevel")Integer productCategoryLevel);

    /**
     * 添加商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 对数据库的影响行数
     */
    Integer insertProductCategory(@Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);
}
