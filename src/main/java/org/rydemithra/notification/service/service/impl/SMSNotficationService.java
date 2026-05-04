package org.rydemithra.notification.service.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.rydemithra.notification.service.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("smsNotificationService")
public class SMSNotficationService implements NotificationService {

    @Value("${twilio.phone-number}")
    private String fromNumber;

    @Override
    public void send(String to, String message) {
        Message.creator(
                new PhoneNumber("+91" + to),   // Receiver
                new PhoneNumber(fromNumber),   // Twilio number
                message
        ).create();
    }

}
