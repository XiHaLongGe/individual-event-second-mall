package com.nf.service.port;

import com.nf.entity.ProductInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname ProductInfService
 * @Date: 2020-02-02 16:50
 * @Description: 商品信息表service层接口
 */
public interface ProductInfService {
    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param productInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<ProductInfEntity> getPageByCondition(Integer pageNum,
                                              Integer pageSize,
                                              ProductInfEntity productInfEntity);


    /**
     * 获取设为轮播展示的商品id
     * @return
     */
    Integer[] getCarouselProductInfId();


    /**
     * 根据商品id获取商品信息
     * @param productInfId 接受修改的商品信息数据
     * @return
     */
    ProductInfEntity getByProductInfId(Integer productInfId);


    /**
     * 根据栏目id获取到相应数据
     * @param categoryId 用来接收栏目id
     * @return
     */
    List<ProductInfEntity> getByColumn(String categoryId);

    /**
     * 获取到关联表中所有的品牌信息id
     * @return
     */
    Integer[] getAllBrandInfId();


    /**
     * 添加商品信息
     * @param productInfEntity 接受添加的商品信息数据
     * @return
     */
    boolean insertProductInf(ProductInfEntity productInfEntity);


    /**
     * 修改商品信息
     * @param productInfEntity 接受修改的商品信息数据
     * @return
     */
    boolean updateProductInf(ProductInfEntity productInfEntity);


    /**
     * 修改商品的轮播展示状态
     * @param productInfEntity 接受修改信息
     * @return
     */
    boolean updateCarousel(ProductInfEntity productInfEntity);



    /**
     * 批量删除商品信息
     * @param productInfIdArray 接收需要删除的商品信息id
     * @return
     */
    boolean batchDeleteBrandInf(Integer [] productInfIdArray);

}
