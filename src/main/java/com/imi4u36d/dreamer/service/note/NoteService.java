package com.imi4u36d.dreamer.service.note;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imi4u36d.dreamer.dto.NoteResDTO;
import com.imi4u36d.dreamer.entity.note.Note;

import java.util.List;

/**
 * <p>
 * 笔记表 服务类
 * </p>
 *
 * @author wz
 * @since 2023-07-25
 */
public interface NoteService extends IService<Note> {

    Page<NoteResDTO> notePage(Integer page, Integer size, String noteTitle, String noteContent, Long userId);
}
