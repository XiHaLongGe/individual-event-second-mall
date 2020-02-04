package com.nf.dao.port;

import com.nf.entity.ProductInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfDao
 * @Date: 2020-02-02 15:50
 * @Description: 商品信息表dao层
 */
public interface ProductInfDao {

    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param productInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<ProductInfEntity> getPageByCondition(@Param("pageNum") Integer pageNum,
                                              @Param("pageSize") Integer pageSize,
                                              @Param("productInfEntity") ProductInfEntity productInfEntity);



    /**
     * 获取到商品信息表中所有的品牌信息id
     * @return
     */
    Integer[] getAllBrandInfId();



    /**
     * 根据商品id获取商品信息
     * @param productInfId 接受修改的商品信息数据
     * @return
     */
    ProductInfEntity getByProductInfId(@Param("productInfId") Integer productInfId);



    /**
     * 添加商品信息
     * @param productInfEntity 接受添加的商品信息数据
     * @return
     */
    Integer insertProductInf(@Param("productInfEntity") ProductInfEntity productInfEntity);


    /**
     * 修改商品信息
     * @param productInfEntity 接受修改的商品信息数据
     * @return
     */
    Integer updateProductInf(@Param("productInfEntity") ProductInfEntity productInfEntity);


    /**
     * 批量删除商品信息
     * @param productInfIdArray 接收需要删除的商品信息id
     * @return 返回对数据库的影响行数
     */
    Integer batchDeleteBrandInf(@Param("productInfIdArray")Integer [] productInfIdArray);

}
