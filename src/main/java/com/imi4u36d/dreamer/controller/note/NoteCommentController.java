package com.imi4u36d.dreamer.controller.note;

import com.imi4u36d.dreamer.dto.NoteCommentDTO;
import com.imi4u36d.dreamer.dto.base.ResultDTO;
import com.imi4u36d.dreamer.service.note.NoteCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 笔记评论表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2023-08-04
 */
@RestController
@RequestMapping("/api/noteComment")
@Tag(name = "笔记评论控制器", description = "笔记评论控制器")
public class NoteCommentController {

    @Autowired
    private NoteCommentService noteCommentService;

    @Operation(summary = "新增评论", description = "新增评论")
    @GetMapping("/addNoteComment")
    @Parameters({
            @Parameter(name = "noteId", description = "笔记id"),
            @Parameter(name = "userId", description = "用户id"),
            @Parameter(name = "comment", description = "评论内容"),
    })
    public ResultDTO<Boolean> addNoteComment(@RequestParam Long noteId, @RequestParam Long userId, @RequestParam String comment) {
        Boolean result = noteCommentService.addNoteComment(noteId, userId, comment);
        return ResultDTO.success(result);
    }


    @Operation(summary = "根据笔记id获取笔记评论列表", description = "根据笔记id获取笔记评论列表")
    @GetMapping("/getNoteCommentListByNoteId")
    @Parameters({
            @Parameter(name = "noteId", description = "笔记id"),
    })
    public ResultDTO<List<NoteCommentDTO>> getNoteCommentListByNoteId(@RequestParam Long noteId) {
        List<NoteCommentDTO> noteCommentList = noteCommentService.getNoteCommentListByNoteId(noteId);
        return ResultDTO.success(noteCommentList);
    }

}
