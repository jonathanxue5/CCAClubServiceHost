package com.codingoutreach.clubservice.service;

import com.codingoutreach.clubservice.dos.PostDO;
import com.codingoutreach.clubservice.dos.PostTabDO;
import com.codingoutreach.clubservice.repository.ClubRepository;
import com.codingoutreach.clubservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDO> getPostsByClubId(UUID clubId) {

        List<PostDO> posts = postRepository.getPostsByClubId(clubId);

        for(PostDO post : posts) {
            List<PostTabDO> tabsForPost = postRepository.getPostTabsByPostId(post.getPostId());
            post.setTabs(tabsForPost);
        }

        return posts;
    }
}
