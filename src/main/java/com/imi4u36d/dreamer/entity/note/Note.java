package com.imi4u36d.dreamer.entity.note;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.imi4u36d.dreamer.dto.NoteDTO;
import com.imi4u36d.dreamer.entity.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 笔记表
 * </p>
 *
 * @author wz
 * @since 2023-07-25
 */
@Getter
@Setter
@TableName("d_note")
@Schema(name = "DNote", description = "$!{table.comment}")
public class Note extends BaseEntity {

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "笔记标题")
    private String noteTitle;

    @Schema(description = "笔记内容")
    private String noteContent;

    public Object toDTO() {
        NoteDTO dto = new NoteDTO();
        BeanUtil.copyProperties(this, dto);
        return dto;
    }
}
