package com.nf.service.port;

import com.nf.entity.CustomerIndividualEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: LJP
 * @Classname CustomerIndividualService
 * @Date: 2020-01-16 10:30
 * @Description: 用户信息表service层接口
 */
public interface CustomerIndividualService {
    /**
     * 根据用户登录ID来获取用户信息表数据
     * @param loginId 用户登录ID
     * @return 用户信息表数据
     */
    CustomerIndividualEntity getByLoginId(Integer loginId);
    /**
     * 添加用户信息，一般是由用户注册操作时调用将用户个人信息添加到用户信息表
     * @param customerIndividualEntity 使用实体类保存用户注册时填入的个人信息，如：联系电话，电子邮箱
     * @return 返回添加的结果
     */
    boolean insertIndividual(CustomerIndividualEntity customerIndividualEntity);
    /**
     * 更新用户信息
     * @param customerIndividualEntity 使用实体类保存用户的更新信息
     * @return 返回更新的结果
     */
    boolean updateCustomer(CustomerIndividualEntity customerIndividualEntity);
}
