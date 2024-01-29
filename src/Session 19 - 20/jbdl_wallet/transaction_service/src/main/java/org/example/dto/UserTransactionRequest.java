package org.example.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTransactionRequest {

    @Min(1)
    private Long walletId;

    @Min(1)
    private Long senderId;

    @Min(1)
    private Long receiverId;

    @DecimalMin("1.0")
    private double amount;
}
