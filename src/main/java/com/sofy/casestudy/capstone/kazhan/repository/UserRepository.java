package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


    boolean existsByUsername(String username);
}
