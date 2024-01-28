package org.example;

import org.example.dto.SendMailNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(SendMailNotification notification) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("pranavvikh03@gmail.com");
        simpleMailMessage.setSubject(notification.getSubject());
        simpleMailMessage.setTo(notification.getReceiverMailId());
        simpleMailMessage.setText(notification.getMessage());
        javaMailSender.send(simpleMailMessage);
    }
}
