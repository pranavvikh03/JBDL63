package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.PaymentStatus;

@Getter
@Setter
@ToString
@Builder
public class SuccessfulTransactionDto {

    private String transactionId;

    private PaymentStatus paymentStatus;
}
