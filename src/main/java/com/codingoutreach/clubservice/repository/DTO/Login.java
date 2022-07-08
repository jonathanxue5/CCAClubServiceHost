package com.codingoutreach.clubservice.repository.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Login {
    @NotBlank
    private String username;

    @NotBlank
    private String encoded_password;
}
