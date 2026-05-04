package org.rydemithra.notification.service.controller;

import org.rydemithra.notification.service.enums.NotificationType;
import org.rydemithra.notification.service.model.request.NotificationRequest;
import org.rydemithra.notification.service.service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notification")
public class NotificationController {

    private final NotificationService emailNotificationService;
    private final NotificationService smsNotificationService;

   // Constructor Injection with Qualifiers
    public NotificationController(
            @Qualifier("emailNotificationService") NotificationService emailNotificationService,
            @Qualifier("smsNotificationService") NotificationService smsNotificationService
    ) {
        this.emailNotificationService = emailNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    @PostMapping("/send")

    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        if (request.getType() == null) {
            return ResponseEntity.badRequest().body("Notification type is required");
        }
        switch (request.getType()) {
            case NotificationType.EMAIL:
                emailNotificationService.send(request.getTo(), request.getMessage());
                return ResponseEntity.ok("Email sent successfully");
            case NotificationType.SMS:
                smsNotificationService.send(request.getTo(), request.getMessage());
                return ResponseEntity.ok("SMS sent successfully");
            default:
                return ResponseEntity.badRequest()
                        .body("Invalid notification type. Supported types: EMAIL, SMS");

        }

    }

}
