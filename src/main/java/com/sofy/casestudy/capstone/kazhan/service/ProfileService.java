package com.sofy.casestudy.capstone.kazhan.service;


import com.sofy.casestudy.capstone.kazhan.entity.Profile;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import com.sofy.casestudy.capstone.kazhan.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//For further development purposes
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository=profileRepository;
    }

    public Profile getProfileById(Long profileId){
        return profileRepository.findById(profileId).orElse(null);
    }

    public Profile getProfileByUser(User user){
        return profileRepository.findByUser(user);

    }

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long profileId){
        profileRepository.deleteById(profileId);
    }




}
