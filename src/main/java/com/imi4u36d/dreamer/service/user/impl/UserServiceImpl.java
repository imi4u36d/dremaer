package com.imi4u36d.dreamer.service.user.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.dto.UserResDTO;
import com.imi4u36d.dreamer.dto.login.LoginResDTO;
import com.imi4u36d.dreamer.entity.user.User;
import com.imi4u36d.dreamer.mapper.UserMapper;
import com.imi4u36d.dreamer.service.LoginService;
import com.imi4u36d.dreamer.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Autowired
    private LoginService loginService;

    @Override
    public UserResDTO signUp(String userName, String pwd) {
        // 校验用户名是否存在 true不存在 false存在
        Boolean isExist = checkUserNameIsExist(userName);
        if (isExist) {
            log.info("用户名{}已存在", userName);
            return null;
        }

        // 保存用户信息
        User user = new User();
        long userId = IdUtil.getSnowflakeNextId();
        user.setId(userId);
        user.setUsername(userName);
        // 设置加密密码
        user.setPwd(SecureUtil.sha256(JWT_SECRET + pwd));
        boolean save = save(user);
        if (!save) {
            log.info("保存用户信息失败");
            throw new RuntimeException("保存用户信息失败");
        }

        // 执行免登操作
        LoginResDTO login = loginService.login(user.getUsername(), user.getPwd());
        if (Objects.isNull(login)) {
            log.info("免登失败");
            throw new RuntimeException("免登失败");
        }

        // 拼装返回对象
        UserResDTO resUser = new UserResDTO();
        resUser.setUserId(userId);
        resUser.setUsername(userName);
        resUser.setToken(login.getToken());
        return resUser;
    }

    /**
     * 校验用户名是否存在
     *
     * @param userName 用户名
     * @return true不存在 false存在
     */
    private Boolean checkUserNameIsExist(String userName) {
        User user = lambdaQuery().eq(User::getUsername, userName).one();
        return Objects.nonNull(user);
    }

    @Override
    public User searchByUserNameAndPwd(String username, String pwd) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(User::getPwd, pwd)
                .and(i -> i.eq(User::getUsername, username)
                        .or().eq(User::getEmail, username));
        return getOne(queryWrapper);
    }

    @Override
    public UserResDTO selectByUserId(String userId) {
        User user = getById(userId);
        if (Objects.isNull(user)) {
            return null;
        }
        return user.toUserResDTO();
    }
}
