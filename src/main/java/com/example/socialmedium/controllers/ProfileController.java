package com.example.socialmedium.controllers;

import com.example.socialmedium.models.Profile;
import com.example.socialmedium.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/delete-profile")
    public String showDeleteForm(@RequestParam("id") int profileId, Model model) {
        Profile profile = profileService.getProfile(profileId);
        model.addAttribute("profile", profile);
        return "home/delete-profile";
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
    public String showUpdateForm(@RequestParam("id") int profileId, Model model) {
        Profile profile = profileService.getProfile(profileId);
        model.addAttribute("profile", profile);
        return "home/update-profile";
    }

    @PostMapping("/update-profile")
    public String update(@RequestParam("id") int profileId, @RequestParam String firstName,
                         @RequestParam String lastName, @RequestParam String email,
                         @RequestParam LocalDateTime dateOfBirth, @RequestParam String gender) {
        profileService.updateProfile(profileId, firstName, lastName, email, dateOfBirth, gender);
        return "redirect:/";
    }


    @GetMapping("/sort-by-lastname")
    public String sortByLastName(Model model) {
        List<Profile> sortedProfiles = profileService.sortByLastName();
        model.addAttribute("profiles", sortedProfiles);
        return "home/index";
    }




}
