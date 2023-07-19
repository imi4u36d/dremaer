package com.imi4u36d.dreamer.service;

import com.imi4u36d.dreamer.dto.login.LoginResDTO;

/**
 * 接口 {@code LoginService} 登陆接口
 * <p>详细描述:登陆接口
 *
 * @author wz
 * 创建时间：2023/7/19 14:35
 * @version v1.0.0
 */
public interface LoginService {
    /**
     * 后端管理系统登陆接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return {@link LoginResDTO} 登陆返回数据模型
     */
    LoginResDTO login(String username, String pwd);
}
