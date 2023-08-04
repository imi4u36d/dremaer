package com.imi4u36d.dreamer.service.note.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imi4u36d.dreamer.dto.NoteCommentDTO;
import com.imi4u36d.dreamer.entity.note.NoteComment;
import com.imi4u36d.dreamer.entity.user.User;
import com.imi4u36d.dreamer.mapper.NoteCommentMapper;
import com.imi4u36d.dreamer.service.note.NoteCommentService;
import com.imi4u36d.dreamer.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 笔记评论表 服务实现类
 * </p>
 *
 * @author wz
 * @since 2023-08-04
 */
@Service
public class DNoteCommentServiceImpl extends ServiceImpl<NoteCommentMapper, NoteComment> implements NoteCommentService {

    @Autowired
    private UserService userService;

    @Override
    public List<NoteCommentDTO> getNoteCommentListByNoteId(Long noteId) {
        LambdaQueryWrapper<NoteComment> queryWrapper = Wrappers.lambdaQuery(NoteComment.class).eq(NoteComment::getNoteId, noteId);
        List<NoteComment> noteCommentList = this.list(queryWrapper);

        List<NoteCommentDTO> NoteCommentDTOList = NoteCommentDTO.convert(noteCommentList)
                .stream()
                .sorted((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()))
                .toList();
        // 获取用户信息
        NoteCommentDTOList.forEach(one -> {
            LambdaQueryWrapper<User> userQuery = Wrappers.lambdaQuery(User.class).eq(User::getId, one.getUserId());
            User user = userService.getOne(userQuery);
            one.setUserName(user.getUsername());
        });
        return NoteCommentDTOList;
    }

    @Override
    public Boolean addNoteComment(Long noteId, Long userId, String comment) {
        NoteComment noteComment = new NoteComment();
        noteComment.setId(IdUtil.getSnowflakeNextId());
        noteComment.setNoteId(noteId);
        noteComment.setUserId(userId);
        noteComment.setComment(comment);
        return this.save(noteComment);
    }
}
