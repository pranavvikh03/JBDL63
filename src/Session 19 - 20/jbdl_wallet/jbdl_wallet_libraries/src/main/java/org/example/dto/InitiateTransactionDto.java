package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class InitiateTransactionDto {

    private Long walletId;

    private Long senderId;

    private Long receiverId;

    private double amount;

    private String transactionId;
}
