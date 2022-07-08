package com.codingoutreach.clubservice.repository;

import com.codingoutreach.clubservice.repository.DTO.Club;
import com.codingoutreach.clubservice.repository.DTO.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginRepository {

    public final String GET_LOGIN_INFO = "SELECT USERNAME, ENCODED_PASSWORD FROM club WHERE username=?";

    private final JdbcTemplate jdbc;

    @Autowired
    public LoginRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Login> getLoginInfo(String username) {
        return jdbc.query(GET_LOGIN_INFO, new Object[]{username}, mapLogin());
    }

    public RowMapper<Login> mapLogin() {
        return ((resultSet, i) ->  {
            String username = resultSet.getString("username");
            String encoded_password = resultSet.getString("encoded_password");
            return new Login(username, encoded_password);
        });
    }
}
