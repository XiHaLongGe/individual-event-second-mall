package com.nf.service.port;

import com.nf.entity.CustomerLoginEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: LJP
 * @Classname CustomerLoginService
 * @Date: 2020-01-12 21:43
 * @Description: 用户登录表service层接口
 */
public interface CustomerLoginService {
    /**
     * 获取到所有用户登录信息列表,并以分页的格式呈现
     * @return 用户登录信息列表(分页后的)
     */
    List<CustomerLoginEntity> getPageAll(Integer pageNum, Integer pageSize);
    /**
     * 根据用户登录ID来获取用户登录表的相关信息
     * @param loginId 用户登录ID
     * @return 用户登录表的相关信息
     */
    CustomerLoginEntity getByLoginId(Integer loginId);

    /**
     * 根据用户帐号来获取用户登录表的相关信息
     * @param loginAccount 用户登录帐号
     * @return 用户登录表的相关信息
     */
    CustomerLoginEntity getByLoginAccount(String loginAccount);

    /**
     * 验证用户登录时输入的账号密码是否正确
     * @param customerLoginEntity 使用实体类保存用户输入的登陆信息
     * @return 根据用户输入的账号密码作为条件在数据库中进行匹配，返回匹配结果
     */
    boolean verifyLogin(CustomerLoginEntity customerLoginEntity);

    /**
     * 验证用户更改密码时原密码是否输入正确
     * @param loginId 用户登录ID
     * @param frontPassword 用户原密码
     * @return 验证结果
     */
    boolean equalsPassword(Integer loginId, String frontPassword);

    /**
     * 更新用户密码
     * @param loginId 用户登录ID
     * @param password 用户新密码
     * @return 更新结果
     */
    boolean updatePassword(Integer loginId, String password);

    /**
     * 新用户注册
     * @param customerLoginEntity 使用实体类保存用户输入的注册信息
     * @return 返回用户的注册结果
     */
    boolean registerCustomer(CustomerLoginEntity customerLoginEntity);

    /**
     * 更新用户的登录信息
     * @param customerLoginEntity 使用实体类保存用户输入的更新信息  如：头像路径、用户昵称
     * @return 返回更新结果
     */
    boolean updatePersonal(CustomerLoginEntity customerLoginEntity);

    /**
     * 修改用户的帐号状态
     * @param customerLoginEntity 使用实体类保存用户输入的注册信息
     * @return 返回修改的结果
     */
    boolean updateAccountStats(CustomerLoginEntity customerLoginEntity);
}
