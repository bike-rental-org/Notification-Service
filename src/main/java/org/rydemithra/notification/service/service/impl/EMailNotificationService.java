package org.rydemithra.notification.service.service.impl;

import org.rydemithra.notification.service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
public class EMailNotificationService implements NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(String to, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(to);
        mail.setSubject("Notification from Bike Rental App");
        mail.setText(message);
        mailSender.send(mail);
    }
}
