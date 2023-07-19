package com.imi4u36d.dreamer.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imi4u36d.dreamer.entity.user.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param pwd      密码
     * @return 注册结果 true成功 false失败
     */
    Boolean signUp(String userName, String pwd);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username 用户名
     * @param pwd      密码
     * @return 用户信息
     */
    User searchByUserNameAndPwd(String username, String pwd);
}
