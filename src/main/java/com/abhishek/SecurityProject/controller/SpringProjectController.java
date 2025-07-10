package com.abhishek.SecurityProject.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringProjectController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Good morning. SessionID:"+request.getSession().getId();
    }
}
