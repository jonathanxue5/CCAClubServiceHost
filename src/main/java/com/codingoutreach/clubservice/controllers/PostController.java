package com.codingoutreach.clubservice.controllers;

import com.codingoutreach.clubservice.dos.ClubInformation;
import com.codingoutreach.clubservice.dos.PostDO;
import com.codingoutreach.clubservice.service.ClubService;
import com.codingoutreach.clubservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("post")
@CrossOrigin
public class PostController {
    //Controllers Needed: Post creation, Post editing

    private PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping
    @RequestMapping(path="/{id}")
    public List<PostDO> getPostsByClubId(@PathVariable("id") UUID clubId) {
        return postService.getPostsByClubId(clubId);
    }
}
