package com.company.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private UserInfo userInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private Long id;
        private String username;
        // private String realName; // Removed as per User entity changes
        // private String avatarUrl; // Removed as per User entity changes
        private Integer role; // Renamed from roleId and matches User entity
    }
}