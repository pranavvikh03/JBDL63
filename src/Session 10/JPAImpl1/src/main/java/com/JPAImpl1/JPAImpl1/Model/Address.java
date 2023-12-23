package com.JPAImpl1.JPAImpl1.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addId;

    private String houseDetails;

    private String city;

    private String pinCode;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
