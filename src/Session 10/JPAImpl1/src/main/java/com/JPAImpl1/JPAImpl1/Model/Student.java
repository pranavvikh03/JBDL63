package com.JPAImpl1.JPAImpl1.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {

    @Id
    private Integer studId;

    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Course> courses;
}
