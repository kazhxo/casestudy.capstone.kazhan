package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.Profile;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//For further development purposes
@Repository

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByUser(User user);



}