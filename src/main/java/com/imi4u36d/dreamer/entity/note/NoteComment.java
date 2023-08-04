package com.imi4u36d.dreamer.entity.note;

import com.baomidou.mybatisplus.annotation.TableName;

import com.imi4u36d.dreamer.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 笔记评论表
 * </p>
 *
 * @author wz
 * @since 2023-08-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("d_note_comment")
@Schema(name = "DNoteComment", description = "$!{table.comment}")
public class NoteComment extends BaseEntity {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "笔记id")
    private Long noteId;

    @Schema(description = "评论内容")
    private String comment;
}
