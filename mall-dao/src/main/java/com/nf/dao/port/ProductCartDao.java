package com.nf.dao.port;

import com.nf.entity.ProductCartEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: LJP
 * @Classname ProductCartDao
 * @Date: 2020-02-07 11:52
 * @Description: 购物车dao层接口
 */
public interface ProductCartDao {

    /**
     * 获得传入用户登录id的购物车中的商品数量
     * @param loginId 用户登录id
     * @return
     */
    Integer getCountByLoginId(@Param("loginId") Integer loginId);

    /**
     * 此方法用于获取用户购物车中某条信息
     * @param productCartEntity 获取条件
     * @return
     */
    ProductCartEntity getProductCart(@Param("productCartEntity") ProductCartEntity productCartEntity);

    /**
     * 修改购物车信息
     * @param productCartEntity 修改信息
     * @return
     */
    Integer updateProductNum(@Param("productCartEntity") ProductCartEntity productCartEntity);

    /**
     * 添加商品到购物车
     * @param productCartEntity 添加信息
     * @return
     */
    Integer insertProduct(@Param("productCartEntity") ProductCartEntity productCartEntity);
}
