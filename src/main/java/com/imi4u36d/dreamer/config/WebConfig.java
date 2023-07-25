package com.imi4u36d.dreamer.config;

import com.imi4u36d.dreamer.config.aspect.AuthHandleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 类 {@code WebConfig} webMVC配置类
 * <p>详细描述:
 *
 * @author wz
 * 创建时间：2023/7/20 09:23
 * @version v1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 身份验证拦截器
    private final AuthHandleInterceptor authHandleInterceptor;

    public WebConfig(AuthHandleInterceptor authHandleInterceptor) {
        this.authHandleInterceptor = authHandleInterceptor;
    }

    /**
     * 身份验证白名单-无需身份验证的路径
     */
    private static final String[] AUTH_PATH_PATTERNS = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/doc.html/**",
            "/api/login",
            "/api-docs/**",
            "/favicon.ico",
            "/api/user/signUp/**",
    };

    /**
     * 添加拦截器让自定义拦截器生效
     *
     * @param registry 拦截器注册器
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加身份验证拦截器
        registry.addInterceptor(authHandleInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(AUTH_PATH_PATTERNS);
    }
}
