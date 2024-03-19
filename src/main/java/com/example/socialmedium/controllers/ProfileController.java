package com.example.socialmedium.controllers;

import com.example.socialmedium.models.Profile;
import com.example.socialmedium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/delete-profile")
    public String delete(@RequestParam("id") int profileId, Model model) {
        model.addAttribute(profileService.getProfile(profileId));
        return "/home/delete-profile";
    }

    @PostMapping("/delete-profile")
    public String delete(@RequestParam int profileId) {
        profileService.delete(profileId);
        return "redirect:/";
    }

    @PostMapping("/new-profile")
    public String insert(@RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam String email, @RequestParam LocalDateTime dateOfBirth,
                         @RequestParam String gender) {
        profileService.insert(firstName, lastName, email, dateOfBirth, gender);
        return "redirect:/";
    }

    @GetMapping("/update-profile")
    public String update(@RequestParam("id") int profileId, Model model) {
        model.addAttribute(profileService.getProfile(profileId));
        return "/home/update-profile";
    }

    @PostMapping("/update-profile")
    public String update(@RequestParam("id") int profileId, @RequestParam String firstName,
                         @RequestParam String lastName, @RequestParam String email,
                         @RequestParam LocalDateTime dateOfBirth, @RequestParam String gender) {
        profileService.updateProfile(profileId, firstName, lastName, email, dateOfBirth, gender);
        return "redirect:/";
    }





}
