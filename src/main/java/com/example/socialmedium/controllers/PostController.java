package com.example.socialmedium.controllers;

import com.example.socialmedium.models.Post;
import com.example.socialmedium.models.Profile;
import com.example.socialmedium.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class PostController {
    @Autowired PostService postService;

    @GetMapping("/delete-post")
    public String showDeleteForm(@RequestParam("id") int postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "home/delete-post";
    }

    @PostMapping("/delete-post")
    public String delete(@RequestParam int postId) {
        postService.delete(postId);
        return "redirect:/";
    }

    @PostMapping("/new-post")
    public String insert(@RequestParam int profileId, @RequestParam String title,
                         @RequestParam String content) {
        LocalDateTime currentDate = LocalDateTime.now();
        postService.insert(profileId, title, content, currentDate);
        return "redirect:/";
    }

    @GetMapping("/update-post")
    public String showUpdatePost(@RequestParam("id") int postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "home/update-post";
    }

    @PostMapping("/update-post")
    public String update(@RequestParam("postId") int postId, @RequestParam int profileId,
                         @RequestParam String title, @RequestParam String content) {
        postService.updatePost(postId, profileId, title, content);
        return "redirect:/";
    }


}
