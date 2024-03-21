package com.example.socialmedium.services;

import com.example.socialmedium.models.Post;
import com.example.socialmedium.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public Post getPost(int postId) {
        return postRepository.getPost(postId);
    }

    public void delete(int postId) {
        postRepository.delete(postId);
    }

    public void insert(int profileId, String title, String content, LocalDateTime currentDate) {
        postRepository.insert(profileId, title, content, currentDate);
    }

    public void updatePost(int postId, int profileId, String title, String content) {
        postRepository.update(postId, profileId, title, content);
    }
}
