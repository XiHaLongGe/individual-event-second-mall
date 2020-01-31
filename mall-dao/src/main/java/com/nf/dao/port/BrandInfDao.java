package com.nf.dao.port;

import com.nf.entity.BrandInfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfDao
 * @Date: 2020-01-31 18:53
 * @Description: 品牌信息表的dao层接口
 */
public interface BrandInfDao {

    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param brandInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<BrandInfEntity> getPageByCondition(@Param("pageNum") Integer pageNum,
                                            @Param("pageSize") Integer pageSize,
                                            @Param("brandInfEntity") BrandInfEntity brandInfEntity);
}
