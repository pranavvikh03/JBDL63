package com.jbdl63.JDBCTemplate.Model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer studId;

    private String studName;

    private String department;

    private Double marks;
}
