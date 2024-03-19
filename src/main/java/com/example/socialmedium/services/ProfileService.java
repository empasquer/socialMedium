package com.example.socialmedium.services;

import com.example.socialmedium.models.Profile;
import com.example.socialmedium.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileReposoitory;

    public List<Profile> getProfiles() {
        return profileReposoitory.getProfiles();
    }
}
