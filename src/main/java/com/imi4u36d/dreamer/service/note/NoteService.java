package com.imi4u36d.dreamer.service.note;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imi4u36d.dreamer.dto.NoteDTO;
import com.imi4u36d.dreamer.entity.note.Note;

/**
 * <p>
 * 笔记表 服务类
 * </p>
 *
 * @author wz
 * @since 2023-07-25
 */
public interface NoteService extends IService<Note> {

    /**
     * 查询笔记
     *
     * @param page        页码 默认1
     * @param size        每页条数 默认10
     * @param noteTitle   笔记标题
     * @param noteContent 笔记内容
     * @param userId      用户id
     * @return 笔记列表
     */
    Page<NoteDTO> notePage(Integer page, Integer size, String noteTitle, String noteContent, Long userId);

    /**
     * 新增笔记
     *
     * @param userId      用户id
     * @param noteTitle   笔记标题
     * @param noteContent 笔记内容
     * @return true or false 成功或失败
     */
    Boolean addNote(Long userId, String noteTitle, String noteContent);

    /**
     * 更新笔记
     *
     * @param noteId      笔记id
     * @param noteTitle   笔记标题
     * @param noteContent 笔记内容
     * @return true or false 成功或失败
     */
    Boolean updateNote(Long noteId, String noteTitle, String noteContent);

    /**
     * 修改笔记状态
     *
     * @param noteId     笔记id
     * @param noteStatus 笔记状态
     * @return true or false 成功或失败
     */
    Boolean updateNoteStatus(Long noteId, Integer noteStatus);
}
