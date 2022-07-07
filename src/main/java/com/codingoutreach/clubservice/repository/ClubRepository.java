package com.codingoutreach.clubservice.repository;

import com.codingoutreach.clubservice.repository.DTO.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ClubRepository {
    private final String GET_ALL_CLUBS = "SELECT * FROM club";

    private final JdbcTemplate jdbc;

    @Autowired
    public ClubRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public List<Club> getAllClubs() {
        return jdbc.query(GET_ALL_CLUBS, mapClub());
    }

    // Turns a column of data into Club object
    public RowMapper<Club> mapClub() {
        return ((resultSet, i) -> {
            UUID clubID = UUID.fromString(resultSet.getString("club_id"));
            String username = resultSet.getString("username");
            String encoded_password = resultSet.getString("encoded_password");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String profile_picture_url = resultSet.getString("profile_picture_url");
            return new Club(clubID, username, encoded_password, name, description, profile_picture_url);
        });
    }

}
