package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.enums.PaymentStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "wallet_transactions")
public class Transaction {

    @Id
    @UuidGenerator
    private String transactionId;

    @Column(nullable = false)
    private Long walletId;

    @Column(nullable = false)
    private Long senderId;

    @Column(nullable = false)
    private Long receiverId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String remark;

    @CreationTimestamp
    private LocalDateTime paymentInitiationDate;

    @UpdateTimestamp
    private LocalDateTime paymentSuccessfulDate;

    public Transaction(Long walletId, Long senderId, Long receiverId, double amount) {
        this.walletId = walletId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }
}
