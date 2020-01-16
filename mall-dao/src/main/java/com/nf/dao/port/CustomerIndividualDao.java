package com.nf.dao.port;

import com.nf.entity.CustomerIndividualEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: LJP
 * @Classname CustomerIndividualDao
 * @Date: 2020-01-12 21:00
 * @Description: 用户信息表dao层接口
 */
public interface CustomerIndividualDao {
    /**
     * 添加用户信息，一般是由用户注册操作时调用将用户个人信息添加到用户信息表
     * @param customerIndividualEntity 使用实体类保存用户注册时填入的个人信息，如：联系电话，电子邮箱
     * @return 返回对数据库的影响行数
     */
    Integer insertIndividual(@Param("customerIndividualEntity")CustomerIndividualEntity customerIndividualEntity);
}
