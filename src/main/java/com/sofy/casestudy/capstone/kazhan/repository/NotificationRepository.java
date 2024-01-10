package com.sofy.casestudy.capstone.kazhan.repository;

import com.sofy.casestudy.capstone.kazhan.entity.Notification;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//For further development purposes
@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

    List<Notification> findByUser(User user);



}

