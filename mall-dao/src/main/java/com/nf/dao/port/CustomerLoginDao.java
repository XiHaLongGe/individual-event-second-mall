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
     * 根据用户登录ID来获取用户登录表的相关信息
     * @param loginId 用户登录ID
     * @return 用户登录表的相关信息
     */
    CustomerLoginEntity getByLoginId(@Param("loginId")Integer loginId);

    /**
     * 根据用户帐号来获取用户登录表的相关信息
     * @param loginAccount 用户登录帐号
     * @return 用户登录表的相关信息
     */
    CustomerLoginEntity getByLoginAccount(@Param("loginAccount")String loginAccount);

    /**
     * 验证用户登录时输入的账号密码是否正确
     * @param customerLoginEntity 使用实体类保存用户输入的登陆信息
     * @return 根据用户输入的账号密码作为条件在数据库中进行匹配，返回匹配结果
     */
    boolean verifyLogin(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);

    /**
     * 验证用户更改密码时原密码是否输入正确
     * @param loginId 用户登录ID
     * @param frontPassword 用户输入密码
     * @return 验证结果
     */
    boolean equalsPassword(@Param("loginId")Integer loginId, @Param("frontPassword")String frontPassword);

    /**
     * 更新用户密码
     * @param loginId 用户登录ID
     * @param password 用户新密码
     * @return 返回对数据库的影响行数
     */
    Integer updatePassword(@Param("loginId")Integer loginId, @Param("password")String password);

    /**
     * 新用户注册
     * @param customerLoginEntity 使用实体类保存用户输入的注册信息
     * @return 返回对数据库的影响行数，在mapper文件中已将添加数据的自增id赋值给
     *         参数CustomerLoginEntity对象的loginId属性中
     */
    Integer registerCustomer(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);

    /**
     * 更新用户的登录信息
     * @param customerLoginEntity 使用实体类保存用户输入的更新信息  如：头像路径、用户昵称
     * @return 返回对数据库的影响行数
     */
    Integer updatePersonal(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);

    /**
     * 修改用户的帐号状态
     * @param customerLoginEntity 使用实体类保存用户输入的注册信息
     * @return 返回对数据库的影响行数
     */
    Integer updateAccountStats(@Param("customerLoginEntity")CustomerLoginEntity customerLoginEntity);
}
