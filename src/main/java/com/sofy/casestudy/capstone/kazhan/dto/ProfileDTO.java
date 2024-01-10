package com.sofy.casestudy.capstone.kazhan.dto;
//For further development purposes
public class ProfileDTO {

    private Long id;
    private long userId;


    public ProfileDTO() {
    }

    public ProfileDTO(Long id, long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
