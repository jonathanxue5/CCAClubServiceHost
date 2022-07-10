package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.controllers.DO.ClubCreationRequest;
import com.codingoutreach.clubservice.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;


    @PostMapping
    public String register (@RequestBody ClubCreationRequest request) {
        return registrationService.register(request);
    }
}