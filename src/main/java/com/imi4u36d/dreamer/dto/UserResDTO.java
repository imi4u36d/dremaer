package com.imi4u36d.dreamer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 {@code UserResDTO} 用户信息返回数据模型
 * <p>详细描述:用户信息返回数据模型
 *
 * @author wz
 * 创建时间：2023/7/19 18:25
 * @version v1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "UserResDTO", description = "用户信息返回数据模型")
public class UserResDTO implements Serializable {

    @Schema(name = "userId", description = "用户id")
    private Long userId;

    @Schema(name = "username", description = "用户名")
    private String username;

}
