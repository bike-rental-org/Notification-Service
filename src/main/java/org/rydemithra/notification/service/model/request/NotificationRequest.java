package org.rydemithra.notification.service.model.request;

import lombok.Getter;
import org.rydemithra.notification.service.enums.NotificationType;

@Getter
public class NotificationRequest {

    private NotificationType type;   // EMAIL or SMS
    private String to;
    private String message;

}
