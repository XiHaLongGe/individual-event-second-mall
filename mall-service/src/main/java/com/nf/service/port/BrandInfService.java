package com.nf.service.port;

import com.nf.entity.BrandInfEntity;

import java.util.List;

/**
 * @Author: LJP
 * @Classname BrandInfService
 * @Date: 2020-01-31 19:09
 * @Description: 品牌信息表service层接口
 */
public interface BrandInfService {
    /**
     * 获取分页后的数据（可根据条件进行检索）
     * @param pageNum 当前页码
     * @param pageSize 每页显示条目
     * @param brandInfEntity 用于接收条件，对数据进行条件搜索
     * @return 分页后的数据列表
     */
    List<BrandInfEntity> getPageByCondition(Integer pageNum,
                                            Integer pageSize,
                                            BrandInfEntity brandInfEntity);
}
