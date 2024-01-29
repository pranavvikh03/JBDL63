package org.example.dto;

import lombok.*;
import org.example.enums.ServiceType;

@Getter
@Setter
@Builder
@ToString
public class SendMailNotification {
    private String receiverMailId;

    private String message;

    private String Subject;

    private ServiceType serviceType;
}
