package com.imi4u36d.dreamer.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.imi4u36d.dreamer.dto.UserResDTO;
import com.imi4u36d.dreamer.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName("d_user")
@Schema(name = "User", description = "$!{table.comment}")
public class User extends BaseEntity {

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "密码")
    private String pwd;

    public UserResDTO toUserResDTO() {
        UserResDTO userResDTO = new UserResDTO();
        userResDTO.setUserId(this.getId());
        userResDTO.setEmail(this.getEmail());
        userResDTO.setUsername(this.getUsername());
        return userResDTO;
    }
}
