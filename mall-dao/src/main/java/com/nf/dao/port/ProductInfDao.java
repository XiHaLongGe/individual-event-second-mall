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

}
