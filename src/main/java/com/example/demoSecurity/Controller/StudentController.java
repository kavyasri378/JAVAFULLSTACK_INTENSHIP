package com.example.demoSecurity.Controller;

import com.example.demoSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>();

    public StudentController() {
        studentList.add(new Student(1, "kavya", "JAVA"));
        studentList.add(new Student(2, "vinish", "SpringBoot"));
    }

    // GET ALL STUDENTS
    @GetMapping("/students")
    public List<Student> getAllStud() {
        return studentList;
    }

    // POST - ADD NEW STUDENT
    @PostMapping("/students")
    public String addStudent(@RequestBody Student student) {
        studentList.add(student);
        return "Student Added Successfully";
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}