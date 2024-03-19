package com.example.socialmedium.repositories;

import com.example.socialmedium.models.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProfileRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Profile> getProfiles() {
        String query = "SELECT * FROM profile;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Profile.class);
        return jdbcTemplate.query(query, rowMapper);

    }

    public void insert(String firstName, String lastName, String email, LocalDateTime dateOfBirth, String gender) {
        String query = "INSERT INTO profile(firstname, lastname, email, date_of_birth, gender) " +
                "VALUES(?, ?, ?, ?, ?);";
        jdbcTemplate.update(query, firstName, lastName, email, dateOfBirth, gender);
    }

    public Profile getProfile(int profileId) {
        String query = "SELECT * FROM profile WHERE profile_id = ?;";
        RowMapper<Profile> rowMapper = new BeanPropertyRowMapper<>(Profile.class);
        return jdbcTemplate.queryForObject(query, rowMapper, profileId);
    }

    public void delete(int profileId) {
        String query = "DELETE FROM profile WHERE profile_id = ?;";
        jdbcTemplate.update(query, profileId);
    }

    public void update(int profileId, String firstName, String lastName, String email, LocalDateTime dateOfBirth, String gender) {
        String query = "UPDATE profile " +
                "SET firstname = ?, " +
                "lastname = ?, " +
                "email = ?, " +
                "date_of_birth = ?, " +
                "gender = ? " +
                "WHERE profile.profile_id = ?";

        jdbcTemplate.update(query, firstName, lastName, email, dateOfBirth, gender, profileId);
    }
}
