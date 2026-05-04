package org.rydemithra.notification.service.service;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {

    void send(String to, String message);
}
