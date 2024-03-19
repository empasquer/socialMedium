package com.example.socialmedium.controllers;

import com.example.socialmedium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    ProfileService profileService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute( "profiles",profileService.getProfiles());
        return "/home/index";
    }

    @GetMapping("/new-profile")
    public String newProfile() {
        return "/home/new-profile";
    }
}
