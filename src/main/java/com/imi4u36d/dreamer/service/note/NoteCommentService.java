package com.imi4u36d.dreamer.service.note;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imi4u36d.dreamer.dto.NoteCommentDTO;
import com.imi4u36d.dreamer.entity.note.NoteComment;

import java.util.List;

/**
 * <p>
 * 笔记评论表 服务类
 * </p>
 *
 * @author wz
 * @since 2023-08-04
 */
public interface NoteCommentService extends IService<NoteComment> {

    /**
     * 根据笔记id获取笔记评论列表
     *
     * @param noteId 笔记id
     * @return 笔记评论列表
     */
    List<NoteCommentDTO> getNoteCommentListByNoteId(Long noteId);

    /**
     * 添加笔记评论
     *
     * @param noteId  笔记id
     * @param userId  用户id
     * @param comment 评论内容
     * @return 是否添加成功
     */
    Boolean addNoteComment(Long noteId, Long userId, String comment);
}
