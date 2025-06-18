package com.company.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import java.util.Arrays;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

            .cors(Customizer.withDefaults())

            .csrf(csrf -> csrf.disable()) // 禁用CSRF，因为我们主要用于API
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 使用无状态会话
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll() // 允许访问根路径 (之前添加的API运行状态检查)
                .requestMatchers("/api/**").permitAll() // 允许所有API接口访问，方便测试
                .requestMatchers("/uploads/**").permitAll() // 允许访问上传文件目录
            );
            // 如果需要JWT过滤器，可以在这里添加
            // http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration configuration = new CorsConfiguration();
                
                // 从请求头中获取"Origin"
                String origin = request.getHeader("Origin");
                
                // 动态判断Origin是否是我们允许的域
                if (origin != null && (origin.equals("https://nekowalker.cn") || origin.endsWith(".nekowalker.cn"))) {
                    // 如果允许，则将该请求的Origin添加到允许列表中
                    // 这是关键：响应头会写上 Access-Control-Allow-Origin: https://xcx.nekowalker.cn
                    configuration.addAllowedOrigin(origin); 
                }
                
                // 设置其他CORS属性
                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                configuration.setAllowedHeaders(Arrays.asList("*"));
                configuration.setAllowCredentials(true);
                configuration.setMaxAge(3600L); // 预检请求的缓存时间，单位秒
                
                return configuration;
            }
        };
    }
}