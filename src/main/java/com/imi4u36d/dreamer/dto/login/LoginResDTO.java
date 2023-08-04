package com.imi4u36d.dreamer.dto.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 {@code LoginResDTO} 登陆返回数据模型
 * <p>详细描述:
 *
 * @author wz
 * 创建时间：2023/7/19 14:47
 * @version v1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "登陆返回数据模型", description = "登陆返回数据模型")
public class LoginResDTO implements Serializable {

    @Schema(name = "userId", description = "用户id")
    private Long userId;

    @Schema(name = "username", description = "用户名")
    private String username;

    @Schema(name = "token", description = "token")
    private String token;
}
