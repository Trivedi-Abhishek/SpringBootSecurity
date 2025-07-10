package com.abhishek.SecurityProject.controller;

import com.abhishek.SecurityProject.model.Users;
import com.abhishek.SecurityProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register-user")
    public Users registerUser(@RequestBody Users user){
        return userService.registerUser(user);
    }
}
