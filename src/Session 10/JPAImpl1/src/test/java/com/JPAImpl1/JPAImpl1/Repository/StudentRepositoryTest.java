package com.JPAImpl1.JPAImpl1.Repository;

import com.JPAImpl1.JPAImpl1.Model.Address;
import com.JPAImpl1.JPAImpl1.Model.Course;
import com.JPAImpl1.JPAImpl1.Model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveData() {
        Student student = Student.builder()
                .name("Pranav")
                .studId(1)
                .build();
        Address address = Address.builder()
                .houseDetails("Dehu Road")
                .pinCode("123456")
                .city("Pune")
                .student(student)
                .build();
        student.setAddress(address);
        studentRepository.save(student);
    }

    @Test
    public void saveDataWithCourses() {
        Student student = Student.builder()
                .name("Pranav")
                .studId(1)
                .build();
        List<Course> courseList = List.of(
                Course.builder().courseName("Java").teacher("Pranav").student(student).build(),
                Course.builder().courseName("SQL").teacher("Mukul").student(student).build()
        );
        student.setCourses(courseList);
        studentRepository.save(student);
    }

}