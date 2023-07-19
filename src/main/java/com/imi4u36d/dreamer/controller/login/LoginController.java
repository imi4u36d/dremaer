package com.imi4u36d.dreamer.controller.login;

import com.imi4u36d.dreamer.dto.base.ResultDTO;
import com.imi4u36d.dreamer.dto.login.LoginResDTO;
import com.imi4u36d.dreamer.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 类 {@code LoginController} 登陆控制器
 * <p>详细描述:登陆控制器
 *
 * @author wz
 * 创建时间：2023/7/19 14:27
 * @version v1.0.0
 */
@RestController
@RequestMapping("/api/login")
@Tag(name = "登陆控制器", description = "登陆控制器")
public class LoginController {

    // 登陆接口
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    @Operation(summary = "登陆接口", description = "后端管理系统登陆接口采用账号密码登陆")
    @Parameters({
            @Parameter(name = "username", description = "用户名", required = true),
            @Parameter(name = "pwd", description = "密码", required = true)
    })
    public ResultDTO<LoginResDTO> login(@RequestParam String username,
                                        @RequestParam String pwd) {
        LoginResDTO resDTO = loginService.login(username, pwd);
        return Objects.nonNull(resDTO) ? ResultDTO.success(resDTO) : ResultDTO.fail("500", "登陆失败-用户名或密码错误");
    }
}
