package com.imi4u36d.dreamer.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类 {@code ResultDTO} 基本返回数据模型
 * <p>详细描述:基本返回数据模型
 *
 * @author wz
 * 创建时间：2023/7/19 14:40
 * @version v1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ResultDTO", description = "基本返回数据模型")
public class ResultDTO<T> implements Serializable {

    /**
     * 返回码
     */
    @Schema(name = "code", description = "返回码")
    private String code;

    /**
     * 返回信息
     */
    @Schema(name = "msg", description = "返回信息")
    private String msg;

    /**
     * 返回数据
     */
    @Schema(name = "data", description = "返回数据")
    private T data;

    /**
     * 提供给成功的时候的调用
     */
    public static <T> ResultDTO<T> success(T data) {
        return new ResultDTO<>("200", "success", data);
    }

    /**
     * 提供给失败的时候的调用
     */
    public static <T> ResultDTO<T> fail(String code, String msg) {
        return new ResultDTO<>(code, msg, null);
    }

}
