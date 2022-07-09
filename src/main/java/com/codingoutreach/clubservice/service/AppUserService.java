package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.appuser.AppUser;
import com.codingoutreach.clubservice.controllers.DO.ClubCreationRequest;
import com.codingoutreach.clubservice.repository.AppUserRepository;
import com.codingoutreach.clubservice.repository.ClubRepository;
import com.codingoutreach.clubservice.repository.DTO.Club;
import com.codingoutreach.clubservice.repository.DTO.ClubUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final ClubRepository clubRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClubUser club = clubRepository.findByEmail(email);
        if (club == null) {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }
        return club;
    }

    public String signUpUser(ClubCreationRequest clubCreationRequest) {
        boolean userExists = clubRepository.findByEmail(clubCreationRequest.getEmail()) != null;

        if (userExists) {
            throw new IllegalStateException("Email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(clubCreationRequest.getPassword());

        UUID club_id = UUID.randomUUID();

        Club clubNew = new Club(club_id, clubCreationRequest.getEmail(), encodedPassword, clubCreationRequest.getName(),
                                clubCreationRequest.getDescription(), clubCreationRequest.getMeet_time(), null);
        clubRepository.createNewClub(clubNew);

        return "Works";
    }
}
