package com.abhishek.SecurityProject.controller;

import com.abhishek.SecurityProject.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> studentList = new ArrayList<>(List.of(new Student("1", "Abhishek", "70"),
            new Student("2", "Ayush", "50")));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }
}
