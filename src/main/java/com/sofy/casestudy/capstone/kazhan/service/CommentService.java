package com.sofy.casestudy.capstone.kazhan.service;


import com.sofy.casestudy.capstone.kazhan.entity.Comment;
import com.sofy.casestudy.capstone.kazhan.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//For further development purposes
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }



    public List<Comment> getAllComments(){
        List<Comment> comments= commentRepository.findAll();
        return comments;
    }
}

