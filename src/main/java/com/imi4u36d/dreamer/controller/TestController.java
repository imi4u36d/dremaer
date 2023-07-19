package com.imi4u36d.dreamer.controller;

import com.imi4u36d.dreamer.dto.TestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "测试控制器", description = "用来测试OpenAPI文档")
@RequestMapping("/api/test")
public class TestController {

    @PostMapping("/")
    @Operation(summary = "测试接口", description = "用来测试OpenAPI文档")
    @Parameter(name = "reqDTO", description = "测试实体", schema = @Schema(implementation = TestDTO.class), required = true)
    public String test(@RequestBody TestDTO reqDTO) {
        return reqDTO.getName();
    }
}
