package com.company.training.filter;

import com.company.training.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                  HttpServletResponse response, 
                                  FilterChain filterChain) throws ServletException, IOException {
        
        String token = request.getHeader("Authorization");
        
        // 跳过登录接口
        if (request.getRequestURI().contains("/auth/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        // 验证token
        if (token != null && jwtUtil.validateToken(token)) {
            // Token有效，继续处理
            filterChain.doFilter(request, response);
        } else {
            // Token无效，返回401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Token无效或已过期\"}");
        }
    }
}