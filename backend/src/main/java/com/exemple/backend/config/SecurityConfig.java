package com.exemple.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.headers()
            .frameOptions()
            .disable();
        http.cors()
            .and()
            .csrf()
            .disable();
        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.httpBasic()
            .and()
            .authorizeHttpRequests((auth) -> {
            	auth.anyRequest().permitAll();
            });
        return http.build();
    }
}
