package com.company.training.service;

import com.company.training.model.LoginRequest;
import com.company.training.model.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse studentLogin(LoginRequest loginRequest);
}