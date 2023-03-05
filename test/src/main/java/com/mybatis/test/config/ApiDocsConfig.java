package com.mybatis.test.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.OpenAPIService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ApiDocsConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("v1").pathsToMatch("/**").build();
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("prj-swagger"));
    }
}
