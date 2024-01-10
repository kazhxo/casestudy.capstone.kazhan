package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.Post;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//The purpose of the repository is to perform database operations
//related to the posts without dealing with the low level
//details of the database operations
//
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    //cjustom query which lists posts associated with a given user
    List<Post> findByUser(User user);








}

