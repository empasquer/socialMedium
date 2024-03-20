package com.example.socialmedium.controllers;

import com.example.socialmedium.services.PostService;
import com.example.socialmedium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ProfileService profileService;
    @Autowired
    PostService postService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute( "profiles",profileService.getProfiles());
        model.addAttribute("posts", postService.getPosts());
        return "/home/index";
    }

    @GetMapping("/new-profile")
    public String newProfile() {
        return "/home/new-profile";
    }
}
