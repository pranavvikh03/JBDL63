package org.example.dto;

import lombok.*;
import org.example.enums.PaymentStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTransactionResponse {

    private String transactionId;

    private String message;

    private LocalDateTime paymentInitiationTime;

    private PaymentStatus status;
}
