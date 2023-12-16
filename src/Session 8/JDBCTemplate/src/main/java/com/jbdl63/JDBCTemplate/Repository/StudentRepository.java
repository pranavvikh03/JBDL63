package com.jbdl63.JDBCTemplate.Repository;

import com.jbdl63.JDBCTemplate.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createNewStudent(Student student) {
        String insertQuery = "INSERT INTO Student (studId, studName, department, marks) VALUES(?, ?, ?, ?)";
        return this.jdbcTemplate.update(insertQuery, student.getStudId(), student.getStudName(), student.getDepartment(), student.getMarks());
    }

    public List<Student> fetchAllStudent() {
        String selectQueryForFetchAll = "SELECT * FROM Student";
        return this.jdbcTemplate.query(selectQueryForFetchAll, (resultSet, rowNo) -> Student.builder()
                .studId(resultSet.getInt("studId"))
                .studName(resultSet.getString("studName"))
                .department(resultSet.getString("department"))
                .marks(resultSet.getDouble("marks"))
                .build());
    }

    public Student fetchStudentById(Integer id) {
        String selectQueryForFetchAll = "SELECT * FROM Student WHERE studId = ?";
        return this.jdbcTemplate.queryForObject(selectQueryForFetchAll, (resultSet, rowNo) -> Student.builder()
                .studId(resultSet.getInt("studId"))
                .studName(resultSet.getString("studName"))
                .department(resultSet.getString("department"))
                .marks(resultSet.getDouble("marks"))
                .build(), id);
    }
}
