package com.imi4u36d.dreamer.service.note.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.dto.NoteDTO;
import com.imi4u36d.dreamer.entity.note.Note;
import com.imi4u36d.dreamer.mapper.NoteMapper;
import com.imi4u36d.dreamer.service.note.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Page<NoteDTO> notePage(Integer page, Integer size, String noteTitle, String noteContent, Long userId) {
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
        Page<NoteDTO> NoteDTOPage = new Page<>();
        NoteDTOPage.setTotal(notePageResult.getTotal());
        NoteDTOPage.setCurrent(notePageResult.getCurrent());
        NoteDTOPage.setSize(notePageResult.getSize());
        NoteDTOPage.setRecords(NoteDTO.convert(notePageResult.getRecords()));
        return NoteDTOPage;
    }

    @Override
    public Boolean addNote(String userId, String noteTitle, String noteContent) {
        Note note = new Note();
        note.setId(IdUtil.getSnowflakeNextId());
        note.setUserId(userId);
        note.setNoteTitle(noteTitle);
        note.setNoteContent(noteContent);
        return this.save(note);
    }

    @Override
    public Boolean updateNote(Long noteId, String noteTitle, String noteContent) {
        Note note = new Note();
        note.setId(noteId);
        note.setNoteTitle(noteTitle);
        note.setNoteContent(noteContent);
        return this.updateById(note);
    }

    @Override
    public Boolean updateNoteStatus(Long noteId, Integer noteStatus) {
        Note note = new Note();
        note.setId(noteId);
        note.setCurStatus(noteStatus);
        return this.updateById(note);
    }
}
