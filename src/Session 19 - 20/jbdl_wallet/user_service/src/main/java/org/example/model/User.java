package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wallet_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "User Full Name is Blank for current user")
    @Column(nullable = false)
    private String userFullName;

    @NotBlank(message = "Mobile Number is Blank for current user")
    @Column(unique = true, nullable = false)
    private String userMobileNo;

    @NotBlank(message = "Email Id is Blank for current user")
    @Column(unique = true, nullable = false)
    private String userEmailId;

    private String userAddress;

    @Column(unique = true)
    private String userPan;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
