package com.imi4u36d.dreamer.service.user.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.entity.user.User;
import com.imi4u36d.dreamer.mapper.UserMapper;
import com.imi4u36d.dreamer.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        User user = new User();
        user.setId(IdUtil.getSnowflakeNextId());
        user.setUsername(userName);
        user.setPwd(pwd);
        return save(user);
    }

    @Override
    public User searchByUserNameAndPwd(String username, String pwd) {
        return lambdaQuery().eq(User::getUsername, username).eq(User::getPwd, pwd).one();
    }
}
