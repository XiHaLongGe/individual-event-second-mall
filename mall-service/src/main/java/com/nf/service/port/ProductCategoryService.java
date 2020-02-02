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
     * 获得父类型id的子类型id
     * @param parentIdArray 用来接收父类型id
     * @return
     */
    String[] getByParentId(String[] parentIdArray);

    /**
     * 通过商品类型id来获得商品类型信息
     * @param productCategoryId 用来接收商品类型id
     * @return
     */
    ProductCategoryEntity getByProductCategoryId(String productCategoryId);

    /**
     * 通过添加数据的类型层级和父类id来获得该层级最大id
     * @param productCategoryEntity 用来接收栏目层级或父类id
     * @return 返回最大id的实体类
     */
    ProductCategoryEntity getBigId(ProductCategoryEntity productCategoryEntity);


    /**
     * 通过父类型id来获得商品类型条目
     * @param parentIdArray 用来接收父类型id
     * @return 接收父类型共有多少子类型条目
     */
    Integer getByParentIdCount(String[] parentIdArray);

    /**
     * 添加商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 添加结果
     */
    boolean insertProductCategory(ProductCategoryEntity productCategoryEntity);


    /**
     * 修改商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 修改结果
     */
    boolean updateProductCategory(ProductCategoryEntity productCategoryEntity);


    /**
     * 根据父id对商品类型进行删除
     * @param parentIdArray 用来接收父id
     * @param cascadeDelete 用来确定是否需要对关联表的相关数据进行删除操作
     * @return 删除结果
     */
    boolean deleteByParentId(String[] parentIdArray, boolean cascadeDelete);


    /**
     * 批量删除商品类型
     * @param productCategoryIdArray 接收需要删除的商品类型id
     * @param cascadeDelete 用来确定是否需要对关联表的相关数据进行删除操作
     * @return 返回批量删除的结果
     */
    boolean batchDeleteProductCategory(String [] productCategoryIdArray, boolean cascadeDelete);
}
