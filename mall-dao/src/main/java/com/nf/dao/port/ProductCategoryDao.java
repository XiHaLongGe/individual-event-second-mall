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
     * 通过商品类型id来获得商品类型信息
     * @param productCategoryId
     * @return
     */
    ProductCategoryEntity getByProductCategoryId(@Param("productCategoryId")String productCategoryId);

    /**
     * 根据商品类型层级来获取到商品类型信息
     * @param productCategoryLevel 商品类型层级
     * @return
     */
    List<ProductCategoryEntity> getByProductCategoryLevel(@Param("productCategoryLevel")Integer productCategoryLevel);

    /**
     * 获取存在关联表中的商品类型
     * @param proCategoryIdArray 用来接收存在关联表中的商品类型id
     * @return
     */
    List<ProductCategoryEntity> getExistPbrData(@Param("proCategoryIdArray") String[] proCategoryIdArray);

    /**
     * 获得父类型id的子类型id
     * @param parentIdArray 用来接收父类型id
     * @return
     */
    String [] getByParentId(@Param("parentIdArray")String[] parentIdArray);

    /**
     * 通过添加数据的类型层级和父类id来获得该层级最大id
     * @param productCategoryEntity 用来接收栏目层级或父类id
     * @return 返回最大id的实体类
     */
    ProductCategoryEntity getBigId(@Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);


    /**
     * 通过关联表id来获得商品类型条目
     * @param pbrIdArray 用来接收关联表id
     * @return 接收父类型共有多少子类型条目
     */
    Integer getByPbrIdCount(@Param("pbrIdArray")String[] pbrIdArray);

    /**
     * 添加商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 对数据库的影响行数
     */
    Integer insertProductCategory(@Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    /**
     * 修改商品类型数据
     * @param productCategoryEntity 用来接收添加的商品类型数据
     * @return 对数据库的影响行数
     */
    Integer updateProductCategory(@Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    /**
     * 根据父id对商品类型进行删除
     * @param parentIdArray 用来接收父id
     * @return 对数据库的影响行数
     */
    Integer deleteByParentId(@Param("parentIdArray")String[] parentIdArray);

    /**
     * 批量删除商品类型
     * @param productCategoryIdArray 接收需要删除的商品类型id
     * @return 返回对数据库的影响行数
     */
    Integer batchDeleteProductCategory(@Param("productCategoryIdArray")String [] productCategoryIdArray);
}
