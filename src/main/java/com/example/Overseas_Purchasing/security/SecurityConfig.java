package com.example.Overseas_Purchasing.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // 關閉 CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // 所有請求不需驗證
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
