package com.company.training.service.impl;

import com.company.training.entity.User;
import com.company.training.mapper.UserMapper;
import com.company.training.model.LoginRequest;
import com.company.training.model.LoginResponse;
import com.company.training.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userMapper.findByUsername(loginRequest.getUsername());

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        if (user.getRole() == 1) {
            throw new RuntimeException("用户不存在");
        }



        String token = UUID.randomUUID().toString();

        LoginResponse.UserInfo userInfo = new LoginResponse.UserInfo(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );

        return new LoginResponse(token, userInfo);
    }
}