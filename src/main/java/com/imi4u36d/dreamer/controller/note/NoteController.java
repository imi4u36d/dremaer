package com.imi4u36d.dreamer.controller.note;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imi4u36d.dreamer.dto.NoteResDTO;
import com.imi4u36d.dreamer.dto.base.ResultDTO;
import com.imi4u36d.dreamer.service.note.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 笔记表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2023-07-25
 */
@RestController
@RequestMapping("/api/note")
@Tag(name = "笔记控制器", description = "笔记控制器")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Operation(summary = "修改笔记状态", description = "修改笔记状态")
    @PostMapping("/updateNoteStatus")
    @Parameters({
            @Parameter(name = "noteId", description = "笔记id"),
            @Parameter(name = "noteStatus", description = "笔记状态"),
    })
    public ResultDTO<Boolean> updateNoteStatus(@RequestParam Long noteId,
                                               @RequestParam Integer noteStatus) {
        Boolean aBoolean = noteService.updateNoteStatus(noteId, noteStatus);
        return ResultDTO.success(aBoolean);
    }

    @Operation(summary = "修改笔记", description = "修改笔记")
    @PostMapping("/updateNote")
    @Parameters({
            @Parameter(name = "noteId", description = "笔记id"),
            @Parameter(name = "noteTitle", description = "笔记标题"),
            @Parameter(name = "noteContent", description = "笔记内容"),
    })
    public ResultDTO<Boolean> updateNote(@RequestParam Long noteId,
                                         @RequestParam String noteTitle,
                                         @RequestParam String noteContent) {
        Boolean aBoolean = noteService.updateNote(noteId, noteTitle, noteContent);
        return ResultDTO.success(aBoolean);
    }

    @Operation(summary = "删除笔记", description = "删除笔记")
    @GetMapping("/deleteNote")
    @Parameters({
            @Parameter(name = "noteId", description = "笔记id"),
    })
    public ResultDTO<Boolean> deleteNote(@RequestParam Long noteId) {
        Boolean aBoolean = noteService.removeById(noteId);
        return ResultDTO.success(aBoolean);
    }


    @Operation(summary = "新增笔记", description = "新增笔记")
    @PostMapping("/addNote")
    @Parameters({
            @Parameter(name = "userId", description = "用户id"),
            @Parameter(name = "noteTitle", description = "笔记标题"),
            @Parameter(name = "noteContent", description = "笔记内容"),
    })
    public ResultDTO<Boolean> addNote(@RequestParam String userId,
                                      @RequestParam String noteTitle,
                                      @RequestParam String noteContent) {
        Boolean aBoolean = noteService.addNote(userId, noteTitle, noteContent);
        return ResultDTO.success(aBoolean);
    }


    @Operation(summary = "查询笔记", description = "查询笔记")
    @GetMapping("/notePage")
    @Parameters({
            @Parameter(name = "page", description = "页码默认1"),
            @Parameter(name = "size", description = "每页条数默认10"),
            @Parameter(name = "noteTitle", description = "笔记标题"),
            @Parameter(name = "noteContent", description = "笔记内容"),
            @Parameter(name = "userId", description = "用户id"),
    })
    public ResultDTO<Page<NoteResDTO>> notePage(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                @RequestParam(required = false, defaultValue = "10") Integer size,
                                                @RequestParam(required = false) String noteTitle,
                                                @RequestParam(required = false) String noteContent,
                                                @RequestParam(required = false) Long userId) {
        Page<NoteResDTO> noteResDTOPage = noteService.notePage(page, size, noteTitle, noteContent, userId);
        return ResultDTO.success(noteResDTOPage);
    }
}
