package com.sofy.casestudy.capstone.kazhan.service;

import com.sofy.casestudy.capstone.kazhan.entity.Notification;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import com.sofy.casestudy.capstone.kazhan.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//For further development purposes
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId).orElse(null);
    }

    public List<Notification> getNotificationsByUser(User user) {
        return notificationRepository.findByUser(user);
    }


    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
