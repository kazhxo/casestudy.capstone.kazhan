package com.sofy.casestudy.capstone.kazhan.entity;

import jakarta.persistence.*;
//For further development purposes
@Entity
@Table(name="notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean read;

    String orderDesc;



    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Notification() {
    }

    public Notification(Long id, String content, boolean read, User user) {
        this.id = id;
        this.content = content;
        this.read = read;
        this.user = user;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
