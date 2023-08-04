package com.imi4u36d.dreamer.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 枚举 {@code ResCode} 返回码枚举
 * <p>详细描述:返回码枚举
 *
 * @author wz
 * 创建时间：2023/7/19 14:43
 * @version v1.0.0
 */
@Schema(name = "返回码枚举", description = "返回码枚举")
public enum ResCode {

    /**
     * 基础成功
     */
    SUCCESS("200", "success"),

    /**
     * 基础失败
     */
    FAIL("500", "fail");

    /**
     * 返回码
     */
    private final String code;

    /**
     * 返回信息
     */
    private final String msg;

    ResCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
