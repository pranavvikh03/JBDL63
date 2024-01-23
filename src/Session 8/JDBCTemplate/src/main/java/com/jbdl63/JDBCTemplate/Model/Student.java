package com.jbdl63.JDBCTemplate.Model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer studId;

    @NotBlank(message = "Student Name should not be null")
    private String studName;

    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "PAN No is not valid")
    private String department;

    @DecimalMin(value= "60.0", message = "Marks should be greater than 60")
    private Double marks;
}
