package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.repository.DTO.Login;
import com.codingoutreach.clubservice.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/auth")
@CrossOrigin
public class LoginController {
    // Add Login information
    public LoginService loginService;


    // Get Login Information
    @GetMapping
    @RequestMapping(path = "/check")
    public List<Login> getLoginInfo(@RequestParam(defaultValue="Guest") String username) {
        return loginService.getLoginInfo(username);
    }
}
