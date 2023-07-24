package com.imi4u36d.dreamer.service.user.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.dto.UserResDTO;
import com.imi4u36d.dreamer.entity.user.User;
import com.imi4u36d.dreamer.mapper.UserMapper;
import com.imi4u36d.dreamer.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public Boolean signUp(String userName, String pwd) {
        // 校验用户名是否存在 true不存在 false存在
        Boolean isExist = checkUserNameIsExist(userName);
        if (isExist) {
            log.info("用户名{}已存在", userName);
            return false;
        }

        // 保存用户信息
        User user = new User();
        user.setId(IdUtil.getSnowflakeNextId());
        user.setUsername(userName);
        // 设置加密密码
        user.setPwd(SecureUtil.sha1(pwd));
        return save(user);
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
        return lambdaQuery().eq(User::getUsername, username).eq(User::getPwd, pwd).one();
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
