package com.imi4u36d.dreamer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "测试实体")
public class TestDTO implements Serializable {

    @Schema(description = "业务ID")
    private Long id;

    @Schema(description = "名称")
    private String name;
}
