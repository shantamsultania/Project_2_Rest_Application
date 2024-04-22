package com.example.javaRestApp.controller;

import com.example.javaRestApp.models.User;
import com.example.javaRestApp.service.UserServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {


    @Autowired
    private UserServiceProvider userServiceProvider;

    @PostMapping("/userRegister")
    public void addUser(@RequestBody User user) {
        userServiceProvider.setUsers(user);
    }

    @PostMapping("/getjwtToken")
    public String getJwtToken() {
        return "";
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userServiceProvider.getAllUsers();
    }
}
