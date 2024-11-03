package com.example.server_9dokme.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/oauth", "/api/logout").permitAll() // 카카오 로그인과 로그아웃은 인증 없이 허용
                .anyRequest().authenticated() // 그 외 요청은 인증 필요
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessUrl("/"); // 로그아웃 성공 시 리다이렉트할 URL 설정

        return http.build();
    }
}
