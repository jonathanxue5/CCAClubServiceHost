package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.service.LoginService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/auth")
@CrossOrigin
public class LoginController {
    // Add Login information
    public LoginService loginService;
}
