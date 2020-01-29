package com.nf.service.port;

import com.nf.entity.ProductCategoryEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductCategoryService
 * @Date: 2020-01-29 10:44
 * @Description: 商品类型表service层接口
 */
public interface ProductCategoryService {
    /**
     * 根据查询条件来获取到商品类型信息
     * @param pageNum 接收当前页码
     * @param pageSize 每页显示数据条目
     * @param productCategoryEntity 用来接收查询条件
     * @return 商品类型信息列表
     */
    List<ProductCategoryEntity> getPageByCondition(Integer pageNum,
                                                   Integer pageSize,
                                                   ProductCategoryEntity productCategoryEntity);

    /**
     * 根据商品类型层级来获取到商品类型信息
     * @param productCategoryLevel 商品类型层级
     * @return
     */
    List<ProductCategoryEntity> getByProductCategoryLevel(Integer productCategoryLevel);


    /**
     * 添加商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 添加结果
     */
    boolean insertProductCategory(ProductCategoryEntity productCategoryEntity);
}
