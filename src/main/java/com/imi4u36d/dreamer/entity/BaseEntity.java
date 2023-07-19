package com.imi4u36d.dreamer.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 类 {@code BaseEntity} 表基本结构
 * <p>详细描述:
 *
 * @author wz
 * 创建时间：2023/7/19 15:10
 * @version v1.0.0
 */
@Data
public class BaseEntity {

    @Schema(name = "autoPk", description = "自增ID")
    protected Long autoPk;


    @Schema(name = "id", description = "业务ID")
    @TableId(type = IdType.INPUT)
    protected Long id;

    @Schema(name = "createdAt", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createdAt;

    @Schema(name = "updatedAt", description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updatedAt;

    @Schema(name = "createdBy", description = "创建人ID")
    @TableField(fill = FieldFill.INSERT)
    protected Long createdBy;

    @Schema(name = "updatedBy", description = "更新人ID")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Long updatedBy;

    @Schema(name = "deleted", description = "逻辑删除的标记位（0：否，1:是）")
    @TableLogic(value = "0", delval = "1")
    @JsonIgnore
    protected Integer isDeleted;

    @Schema(name = "curVersion", description = "当前版本号")
    @JsonIgnore
    protected Integer curVersion;
}
