package com.imi4u36d.dreamer.controller.user;

import com.imi4u36d.dreamer.dto.UserResDTO;
import com.imi4u36d.dreamer.dto.base.ResultDTO;
import com.imi4u36d.dreamer.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wz
 * @since 2023-07-19
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "用户控制器", description = "用户控制器")
public class UserController {

    // 用户接口
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "注册接口", description = "注册接口")
    @PostMapping("/signUp")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true),
            @Parameter(name = "pwd", description = "密码", required = true)
    })
    public ResultDTO<Boolean> signUp(@RequestParam String username, @RequestParam String pwd) {
        Boolean res = userService.signUp(username, pwd);
        return res ? ResultDTO.success(res) : ResultDTO.fail("500", "注册失败");
    }

    @Operation(summary = "根据用户id查询用户信息", description = "根据用户id查询用户信息")
    @GetMapping("/selectByUserId")
    @Parameters({
            @Parameter(name = "userId", description = "用户id", required = true)
    })
    public ResultDTO<UserResDTO> selectByUserId(@RequestParam String userId) {
        UserResDTO res = userService.selectByUserId(userId);
        return Objects.nonNull(res) ? ResultDTO.success(res) : ResultDTO.fail("500", "用户不存在");
    }

}
