package com.sofy.casestudy.capstone.kazhan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

    private Long user_id;

    @NotEmpty
    private String username;
    private String password;
    @NotEmpty
    @Email
    private String email;
    private String profilePicture;
    private String bio;

    public UserDTO() {
    }

    public UserDTO(Long userId, String username, String email, String profilePicture, String bio) {
        this.user_id = userId;
        this.username = username;
        this.email = email;
        this.profilePicture = profilePicture;
        this.bio = bio;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
