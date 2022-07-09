package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.appuser.AppUser;
import com.codingoutreach.clubservice.appuser.AppUserRole;
import com.codingoutreach.clubservice.controllers.DO.ClubCreationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailService emailService;

    public String register(ClubCreationRequest request) {
        boolean isValidEmail = emailService.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        return appUserService.signUpUser(request);
    }
}
