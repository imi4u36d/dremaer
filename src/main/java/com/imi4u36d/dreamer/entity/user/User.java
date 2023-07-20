package com.imi4u36d.dreamer.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imi4u36d.dreamer.dto.UserResDTO;
import com.imi4u36d.dreamer.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
@Getter
@Setter
@TableName("d_user")
@Schema(name = "User", description = "$!{table.comment}")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String pwd;

    @Schema(description = "当前状态 0未启用 1启用")
    private Byte curStatus;

    public UserResDTO toUserResDTO() {
        UserResDTO userResDTO = new UserResDTO();
        userResDTO.setUserId(this.getId());
        userResDTO.setUsername(this.getUsername());
        userResDTO.setCurStatus(this.getCurStatus());
        return userResDTO;
    }
}
