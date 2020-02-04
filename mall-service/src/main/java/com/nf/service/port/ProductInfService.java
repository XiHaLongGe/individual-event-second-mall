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
     * 获取到关联表中所有的品牌信息id
     * @return
     */
    Integer[] getAllBrandInfId();

}
