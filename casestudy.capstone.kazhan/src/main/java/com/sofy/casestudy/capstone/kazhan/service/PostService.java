package com.sofy.casestudy.capstone.kazhan.service;


import com.sofy.casestudy.capstone.kazhan.entity.Post;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import com.sofy.casestudy.capstone.kazhan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    public Post getPostById(Long postId){
        return postRepository.findById(postId).orElse(null);
    }

    public List<Post> getPostsByUser(User user){
        return postRepository.findByUser(user);
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }

}

