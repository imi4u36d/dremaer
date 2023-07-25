package com.imi4u36d.dreamer.dto;

import cn.hutool.core.bean.BeanUtil;
import com.imi4u36d.dreamer.entity.note.Note;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 类 {@code NoteResDTO} 笔记返回数据模型
 * <p>详细描述:
 *
 * @author wz
 * 创建时间：2023/7/25 16:41
 * @version v1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "NoteResDTO", description = "笔记返回数据模型")
public class NoteResDTO implements Serializable {

    @Schema(description = "用户id")
    private String userId;

    @Schema(description = "笔记标题")
    private String noteTitle;

    @Schema(description = "笔记内容")
    private String noteContent;

    @Schema(description = "当前状态 0未启用 1启用")
    private Byte curStatus;


    public static List<NoteResDTO> convert(List<Note> records) {
        return BeanUtil.copyToList(records, NoteResDTO.class);
    }
}
