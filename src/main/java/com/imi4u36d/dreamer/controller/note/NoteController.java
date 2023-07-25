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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "查询笔记", description = "注册接口")
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
