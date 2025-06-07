package com.company.training.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    
    // 从配置文件读取JWT密钥
    @Value("${jwt.secret}")
    private String jwtSecret;
    
    // 从配置文件读取过期时间
    @Value("${jwt.expiration}")
    private long expirationTime;
    
    /**
     * 生成JWT Token
     * @param userId 用户ID
     * @return JWT Token字符串
     */
    public String generateToken(Long userId) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }
    
    /**
     * 从Token中解析用户ID
     * @param token JWT Token（可能包含"Bearer "前缀）
     * @return 用户ID
     * @throws RuntimeException 如果token无效或过期
     */
    public Long parseUserId(String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
                    
            return Long.valueOf(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException("Token解析失败: " + e.getMessage());
        }
    }
    
    /**
     * 验证Token是否有效
     * @param token JWT Token
     * @return true表示有效，false表示无效
     */
    public boolean validateToken(String token) {
        try {
            parseUserId(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * 从Token中获取过期时间
     * @param token JWT Token
     * @return 过期时间
     */
    public Date getExpirationDate(String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
                    
            return claims.getExpiration();
        } catch (Exception e) {
            throw new RuntimeException("Token解析失败: " + e.getMessage());
        }
    }
    
    /**
     * 检查Token是否即将过期（5分钟内）
     * @param token JWT Token
     * @return true表示即将过期
     */
    public boolean isTokenExpiringSoon(String token) {
        try {
            Date expirationDate = getExpirationDate(token);
            Date now = new Date();
            long timeUntilExpiration = expirationDate.getTime() - now.getTime();
            return timeUntilExpiration < (5 * 60 * 1000); // 5分钟
        } catch (Exception e) {
            return true; // 如果解析失败，认为即将过期
        }
    }
}