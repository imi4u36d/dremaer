package com.imi4u36d.dreamer.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApi 配置
 */
@Configuration
public class OpenApiConfig {
    /**
     * SpringDoc 标题、描述、版本等信息配置
     *
     * @return openApi 配置信息
     */
    @Bean
    public OpenAPI springDocOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.APIKEY).scheme("basic")
                                .in(SecurityScheme.In.HEADER).name("token")))
//                        .addParameters("paramsKey", new Parameter().in("header").schema(new StringSchema()).name("token"))
//                        .addHeaders("headerKey", new Header().description("token").schema(new StringSchema())))
                .addSecurityItem(new SecurityRequirement().addList("basicScheme"))
                .info(new Info()
                        .title("Dreamer API")
                        .description("Dreamer接口文档说明")
                        .version("v0.0.1-SNAPSHOT"));
    }
}
