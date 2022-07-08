package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.request.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "Works";
    }
}
