package com.jbdl63.JDBCTemplate.Controller;

import com.jbdl63.JDBCTemplate.Model.Student;
import com.jbdl63.JDBCTemplate.Service.StudentService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        if(studentService.createNewStudent(student) == 1)
            return new ResponseEntity<>(String.format("New Student with Name:%s is Added", student.getStudName()), HttpStatus.CREATED);
        return new ResponseEntity<>("Insertion Failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents() {
        try{
            return new ResponseEntity<>(studentService.fetchAllStudents(), HttpStatus.OK);
        } catch(RuntimeException e){
            log.error("Exception occured: ", e.getMessage());
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> fetchStudentById(@PathVariable("id") Integer id) {
        try{
            return new ResponseEntity<>(studentService.fetchStudentById(id), HttpStatus.OK);
        } catch(RuntimeException e){
            log.error("Exception occured: ", e.getMessage());
        }
        return null;
    }
}
