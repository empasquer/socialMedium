package com.example.socialmedium.controllers;

import com.example.socialmedium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @PostMapping("/new-profile")
    public String insert(@RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam String email, @RequestParam LocalDateTime dateOfBirth,
                         @RequestParam String gender) {
        profileService.insert(firstName, lastName, email, dateOfBirth, gender);
        return "redirect:/";
    }
}
