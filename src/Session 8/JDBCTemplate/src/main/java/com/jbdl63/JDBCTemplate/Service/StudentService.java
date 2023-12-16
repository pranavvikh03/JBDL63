package com.jbdl63.JDBCTemplate.Service;

import com.jbdl63.JDBCTemplate.Model.Student;
import com.jbdl63.JDBCTemplate.Repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public int createNewStudent(Student student) {
        log.info("Student Body Received:", student.toString());
        return studentRepository.createNewStudent(student);
    }

    public List<Student> fetchAllStudents() {
        List<Student> studentList = studentRepository.fetchAllStudent();
        if(studentList.isEmpty()) {
            log.error("No students exist");
            throw new RuntimeException("No Students Exist");
        }
        return studentList;
    }
    public Student fetchStudentById(Integer id) {
        Student student = studentRepository.fetchStudentById(id);
        if(student == null) {
            log.error("No student exist");
            throw new RuntimeException("No Student Exist");
        }
        return student;
    }
}
