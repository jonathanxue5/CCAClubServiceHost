package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.request.RegistrationRequest;
import com.codingoutreach.clubservice.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;


    public String register (@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}