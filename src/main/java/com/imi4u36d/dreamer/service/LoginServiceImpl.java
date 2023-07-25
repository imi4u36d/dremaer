package com.imi4u36d.dreamer.service;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.imi4u36d.dreamer.dto.login.LoginResDTO;
import com.imi4u36d.dreamer.entity.user.User;
import com.imi4u36d.dreamer.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 类 {@code LoginServiceImpl} 登陆接口实现类
 * <p>详细描述:登陆接口实现类
 *
 * @author wz
 * 创建时间：2023/7/19 14:36
 * @version v1.0.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {

    // JWT KEY
    private static final String KEY = "imi4u36d";

    // 用户接口
    private final UserService userService;

    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * 后端管理系统登陆接口
     *
     * @param username 用户名
     * @param pwd      密码
     * @return {@link LoginResDTO} 登陆返回数据模型
     */
    @Override
    public LoginResDTO login(String username, String pwd) {
        User user = userService.searchByUserNameAndPwd(username, pwd);
        if (Objects.nonNull(user)) {
            // 生成token
            Map<String, Object> tokenMap = new HashMap<>(2);
            tokenMap.put("id", user.getId());
            tokenMap.put("username", user.getUsername());
            // 获取10分钟后的Date对象
            Date expAt = new Date(System.currentTimeMillis() + 10 * 60 * 1000);
            String token = JWT.create().addPayloads(tokenMap).setKey(KEY.getBytes()).setExpiresAt(expAt).sign();
            return LoginResDTO.builder().userId(user.getId()).username(user.getUsername()).token(token).build();
        } else {
            return new LoginResDTO();
        }
    }
}
