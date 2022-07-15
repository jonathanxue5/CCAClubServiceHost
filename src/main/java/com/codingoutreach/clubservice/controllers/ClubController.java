package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.dos.ClubInformation;
import com.codingoutreach.clubservice.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("club")
@CrossOrigin
public class ClubController {
    //Controllers Needed: Get All Clubs, Get Clubs Based on Search Query, Get Club Information, Get Club Posts, Description Change Endpoint

    private ClubService clubService;


    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    /**
     * @param clubId ID of Club
     * @return All information needed to load Club Profile page for club identified with {@code clubId}
     */
    @GetMapping
    @RequestMapping(path="/information/{id}")
    public ClubInformation getClubInformationByClubId(@PathVariable("id") UUID clubId) {
        return clubService.getClubInformationByClubId(clubId);
    }


}
