package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.appuser.AppUser;
import com.codingoutreach.clubservice.appuser.AppUserRole;
import com.codingoutreach.clubservice.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailService emailService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailService.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
