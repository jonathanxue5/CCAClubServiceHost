package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.repository.DTO.Login;
import com.codingoutreach.clubservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Login> getLoginInfo(String username) {
        return loginRepository.getLoginInfo(username);
    }
}
