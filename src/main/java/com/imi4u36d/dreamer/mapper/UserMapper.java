package com.imi4u36d.dreamer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imi4u36d.dreamer.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
