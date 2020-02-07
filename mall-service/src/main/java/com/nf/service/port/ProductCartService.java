package com.nf.service.port;

import com.nf.entity.ProductCartEntity;

/**
 * @Author: LJP
 * @Classname ProductCartService
 * @Date: 2020-02-07 11:59
 * @Description: 购物车service接口层
 */
public interface ProductCartService {

    /**
     * 获得传入用户登录id的购物车中的商品数量
     * @param loginId 用户登录id
     * @return
     */
    Integer getCountByLoginId(Integer loginId);

    /**
     * 此方法用于获取用户购物车中某条信息
     * @param productCartEntity 获取条件
     * @return
     */
    ProductCartEntity getProductCart(ProductCartEntity productCartEntity);

    /**
     * 修改购物车信息
     * @param productCartEntity 修改信息
     * @return
     */
    boolean updateProductNum(ProductCartEntity productCartEntity);


    /**
     * 添加商品到购物车
     * @param productCartEntity 添加信息
     * @return
     */
    boolean insertProduct(ProductCartEntity productCartEntity);

    /**
     * 此方法用来 判断用户传输过来的数据 来对数据库的操作是添加还是修改
     * @param productCartEntity 用户传输过来的数据
     * @return
     */
    boolean addCart(ProductCartEntity productCartEntity);
}
