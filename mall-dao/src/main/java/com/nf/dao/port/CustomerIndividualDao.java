package com.nf.dao.port;

import com.nf.entity.CustomerIndividualEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerIndividualDao
 * @Date: 2020-01-12 21:00
 * @Description: 用户信息表dao层接口
 */
public interface CustomerIndividualDao {
    /**
     * 获取到所有用户信息列表,并以分页的格式呈现
     * @param pageNum 接收当前页码
     * @param pageSize 每页显示数据条目
     * @return 用户信息列表(分页后的)
     */
    List<CustomerIndividualEntity> getPageAll(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 根据用户出生年月日、姓名、性别进行条件查询
     * @param pageNum 接收当前页码
     * @param pageSize 每页显示数据条目
     * @param customerIndividualEntity 通过用户信息实体类来接收用户进行查询的条件
     * @return 根据用户所选条件查询结果的列表(分页后的)
     */
    List<CustomerIndividualEntity> getPageByCondition(@Param("pageNum") Integer pageNum,
                                                 @Param("pageSize") Integer pageSize,
                                                 @Param("customerIndividualEntity")CustomerIndividualEntity customerIndividualEntity);

    /**
     * 根据用户登录ID来获取用户信息表数据
     * @param loginId 用户登录ID
     * @return 用户信息表数据
     */
    CustomerIndividualEntity getByLoginId(@Param("loginId")Integer loginId);

    /**
     * 添加用户信息，一般是由用户注册操作时调用将用户个人信息添加到用户信息表
     * @param customerIndividualEntity 使用实体类保存用户注册时填入的个人信息，如：联系电话，电子邮箱
     * @return 返回对数据库的影响行数
     */
    Integer insertIndividual(@Param("customerIndividualEntity")CustomerIndividualEntity customerIndividualEntity);

    /**
     * 更新用户信息
     * @param customerIndividualEntity 使用实体类保存用户的更新信息
     * @return 返回对数据库的影响行数
     */
    Integer updateCustomer(@Param("customerIndividualEntity")CustomerIndividualEntity customerIndividualEntity);

    /**
     * 删除用户
     * @param loginId 接收需要删除的用户id
     * @return 返回对数据库的影响行数
     */
    Integer deleteCustomer(@Param("loginId")Integer loginId);

    /**
     * 批量删除用户
     * @param loginIdArray 接收需要删除的用户id
     * @return 返回对数据库的影响行数
     */
    Integer batchDeleteCustomer(@Param("loginIdArray")Integer [] loginIdArray);
}
