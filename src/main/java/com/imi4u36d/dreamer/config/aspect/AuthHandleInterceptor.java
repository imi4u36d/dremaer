package com.imi4u36d.dreamer.config.aspect;

import cn.hutool.jwt.JWTValidator;
import com.imi4u36d.dreamer.dto.base.ResultDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 类 {@code AuthHandleInterceptor} 身份验证拦截器
 * <p>详细描述:
 *
 * @author wz
 * 创建时间：2023/7/20 09:06
 * @version v1.0.0
 */
@Slf4j
@Component
public class AuthHandleInterceptor implements HandlerInterceptor {

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    /**
     * 在这里验证用户身份，如果验证失败，返回false，否则返回true
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return {@code true} if the execution chain should proceed with the
     * @throws Exception in case of errors
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求参数中header的token字段
        String token = request.getHeader("token");
        // 如果token为空，返回false
        if (!StringUtils.hasText(token)) {
            // 身份验证出错
            ResultDTO<Object> resultDTO = ResultDTO.builder().code("401").msg("身份验证出错-token非法").build();
            log.info("身份验证出错-token非法[空token]");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resultDTO.toString());
            return false;
        }

        // 校验token是否合法
        try {
            JWTValidator.of(token).validateDate();
        } catch (Exception e) {
            // 身份验证出错
            ResultDTO<Object> resultDTO = ResultDTO.builder().code("401").msg("身份验证出错：" + e.getMessage()).build();
            log.info("身份验证出错：{}", e.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(resultDTO.toString());
            return false;
        }

        // 身份验证通过
        return true;
    }
}
