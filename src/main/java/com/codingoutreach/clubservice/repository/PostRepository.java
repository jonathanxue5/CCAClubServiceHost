package com.codingoutreach.clubservice.repository;

import com.codingoutreach.clubservice.dos.PostDO;
import com.codingoutreach.clubservice.dos.PostTabDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PostRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String GET_POSTS_FOR_CLUB_SQL = "SELECT * FROM post WHERE sender=?";
    private final String GET_POST_TABS_FOR_POST_ID = "SELECT * FROM post_tab WHERE post_id=?";

    public List<PostDO> getPostsByClubId(UUID clubId) {
        return jdbcTemplate.query(GET_POSTS_FOR_CLUB_SQL, new Object[]{clubId}, mapPost());
    }

    public List<PostTabDO> getPostTabsByPostId(UUID postId) {
        return jdbcTemplate.query(GET_POST_TABS_FOR_POST_ID, new Object[]{postId}, mapPostTab());
    }

    public RowMapper<PostDO> mapPost() {
        return (resultSet, i) -> {
            UUID postId = UUID.fromString(resultSet.getString("post_id"));
            UUID clubId = UUID.fromString(resultSet.getString("sender"));
            String title = resultSet.getString("title");
            return new PostDO(postId, clubId, title, new ArrayList<PostTabDO>());
        };
    }

    public RowMapper<PostTabDO> mapPostTab() {
        return (resultSet, i) -> {
            UUID tabId = UUID.fromString(resultSet.getString("tab_id"));
            UUID postId = UUID.fromString(resultSet.getString("post_id"));
            String header = resultSet.getString("header");
            String textContent = resultSet.getString("text_content");
            String mediaURL = resultSet.getString("media_url");
            return new PostTabDO(tabId, postId, header, textContent, mediaURL);
        };
    }

}
