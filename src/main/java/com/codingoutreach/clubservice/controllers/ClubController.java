package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.repository.DTO.Club;
import com.codingoutreach.clubservice.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path ="/club")
@CrossOrigin
public class ClubController {

    private ClubService clubService;


    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }


//     Get All Clubs
    @GetMapping
    @RequestMapping(path = "/list")
    public List<Club> getClubs() {
        return clubService.getAllClubs();
    }

    // Get Club Information
    @GetMapping
    @RequestMapping(path = "/{id}/info", method = GET)
    @ResponseBody
    public String clubInfo(@PathVariable("id") int id) {
        return "The id is " + id;
    }

    // Get Clubs Based on Search Query



    //Controllers Needed: Get All Clubs, Get Clubs Based on Search Query, Get Club Information, Get Club Posts, Description Change Endpoint
}
