package com.example.server_9dokme.common.config;

// CORS error 해결을 위한 WebConfig.java
// 추후 수정 필요

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //어떤 URI로 들어오는 요청을 허용할 것인가?
                .allowedOrigins("http://localhost:3000", "http://localhost:8080", "https://www.9dokme.p-e.kr") // 특정 도메인만 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
