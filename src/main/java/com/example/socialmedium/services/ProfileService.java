package com.example.socialmedium.services;

import com.example.socialmedium.models.Profile;
import com.example.socialmedium.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.getProfiles();
    }

    public void insert(String firstName, String lastName, String email, LocalDate dateOfBirth, String gender) {
        profileRepository.insert(firstName, lastName, email, dateOfBirth, gender);
    }

    public Profile getProfile(int profileId) {
        return profileRepository.getProfile(profileId);
    }

    public void delete(int profileId) {
        profileRepository.delete(profileId);
    }


    public void updateProfile(int profileId, String firstName, String lastName, String email, LocalDateTime dateOfBirth, String gender) {
        profileRepository.update(profileId, firstName, lastName, email, dateOfBirth, gender);
    }

    public List<Profile> sortByLastNameAsc() {
        return profileRepository.sortByLastNameAsc();
    }

    public List<Profile> sortByLastNameDesc() {
        return profileRepository.sortByLastNameDesc();
    }
}
