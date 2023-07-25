package com.imi4u36d.dreamer.service.note.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.dto.NoteResDTO;
import com.imi4u36d.dreamer.entity.note.Note;
import com.imi4u36d.dreamer.mapper.NoteMapper;
import com.imi4u36d.dreamer.service.note.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 笔记表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2023-07-25
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Override
    public Page<NoteResDTO> notePage(Integer page, Integer size, String noteTitle, String noteContent, Long userId) {

        // 构造分页对象
        Page<Note> notePage = new Page<>(page, size);
        // 构造查询条件
        LambdaQueryWrapper<Note> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(noteTitle), Note::getNoteTitle, noteTitle)
                .eq(StringUtils.hasText(noteContent), Note::getNoteContent, noteContent)
                .eq(userId != null, Note::getUserId, userId);
        // 执行查询
        Page<Note> notePageResult = this.page(notePage, queryWrapper);
        // 构造返回对象
        Page<NoteResDTO> noteResDTOPage = new Page<>();
        noteResDTOPage.setTotal(notePageResult.getTotal());
        noteResDTOPage.setRecords(NoteResDTO.convert(notePageResult.getRecords()));
        return noteResDTOPage;
    }
}
