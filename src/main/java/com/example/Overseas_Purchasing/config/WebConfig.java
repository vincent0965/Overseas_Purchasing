package com.example.Overseas_Purchasing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "http://localhost:5173",
                                "http://127.0.0.1:5173"
                        ) // 允許前端開發網址
                        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS") // 允許所有 HTTP 方法
                        .allowedHeaders("*")                     // 允許所有 Header
                        .allowCredentials(true);                 // 若有需要傳 cookie/token
            }
        };
    }
}
