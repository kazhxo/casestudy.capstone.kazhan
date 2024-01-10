package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.Comment;
import com.sofy.casestudy.capstone.kazhan.entity.Post;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//For further development purposes
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPost(Post post);

    List<Comment> findByUser(User user);

}
