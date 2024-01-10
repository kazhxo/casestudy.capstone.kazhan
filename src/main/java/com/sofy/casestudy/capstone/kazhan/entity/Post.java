package com.sofy.casestudy.capstone.kazhan.entity;


import jakarta.persistence.*;


//This is the post entity class which holds the data relating to the post
//Entity annotation creates table in sql for posts
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;





    @Lob
    private String content;  // Text content

    private String imageUrl;  //  url for the image


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Post() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Post(Long postId, String content, User user) {
        this.postId = postId;
        this.content = content;
        this.user = user;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
