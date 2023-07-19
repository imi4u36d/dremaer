package com.imi4u36d.dreamer.controller.user;

import com.imi4u36d.dreamer.dto.base.ResultDTO;
import com.imi4u36d.dreamer.service.user.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/signUp")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true),
            @Parameter(name = "pwd", description = "密码", required = true)
    })
    public ResultDTO<Boolean> signUp(@RequestParam String username, @RequestParam String pwd) {
        Boolean res = userService.signUp(username, pwd);
        return res ? ResultDTO.success(res) : ResultDTO.fail("500", "注册失败");
    }

}
