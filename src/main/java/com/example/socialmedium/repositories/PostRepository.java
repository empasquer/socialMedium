package com.example.socialmedium.repositories;

import com.example.socialmedium.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PostRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Post> getPosts() {
        String query = "SELECT * FROM post;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Post.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public Post getPost(int postId) {
        String query = "SELECT * FROM post WHERE post_id = ?;";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return jdbcTemplate.queryForObject(query, rowMapper, postId);
    }

    public void delete(int postId) {
        String query = "DELETE FROM post WHERE post_id = ?;";
        jdbcTemplate.update(query, postId);
    }

    public void insert(int profileId, String title, String content, LocalDate createdAt) {
        String query = "INSERT INTO post (profile_id, title, content, created_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, profileId, title, content, createdAt);
    }

}
