package com.imi4u36d.dreamer.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imi4u36d.dreamer.entity.BaseEntity;
import com.imi4u36d.dreamer.entity.note.NoteComment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 笔记评论表
 * </p>
 *
 * @author wz
 * @since 2023-08-04
 */
@Getter
@Setter
@TableName("d_note_comment")
@Schema(name = "笔记评论返回数据模型", description = "笔记评论返回数据模型")
public class NoteCommentDTO implements Serializable {

    @Schema(description = "用户id")
    private String userId;

    @Schema(description = "用户id")
    private String userName;

    @Schema(description = "笔记id")
    private String noteId;

    @Schema(description = "评论内容")
    private String comment;

    @Schema(name = "创建时间/评论时间", description = "创建时间/评论时间")
    protected String createdAt;

    public static List<NoteCommentDTO> convert(List<NoteComment> noteCommentList) {
        if (CollectionUtil.isEmpty(noteCommentList)) {
            return Collections.emptyList();
        }
        return BeanUtil.copyToList(noteCommentList, NoteCommentDTO.class);
    }

}
