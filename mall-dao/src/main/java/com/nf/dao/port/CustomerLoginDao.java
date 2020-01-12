package com.nf.dao.port;

import com.nf.entity.CustomerLoginEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: LJP
 * @Classname CustomerLoginDao
 * @Date: 2020-01-12 21:00
 * @Description: 用户登录表dao层接口
 */
public interface CustomerLoginDao {
    /**
     * 验证用户登录时输入的账号密码是否正确
     * @param customerLoginEntity 使用实体类保存用户输入的登陆信息
     * @return 根据用户输入的账号密码作为条件在数据库中进行匹配，返回匹配结果
     */
    boolean verifyLogin(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);
}
