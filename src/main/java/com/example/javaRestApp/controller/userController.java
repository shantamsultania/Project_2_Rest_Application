package com.example.javaRestApp.controller;

import com.example.javaRestApp.DTO.AuthRequest;
import com.example.javaRestApp.entiy.User;
import com.example.javaRestApp.service.UserServiceProvider;
import com.example.javaRestApp.utils.JwtGeneratorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {


    @Autowired
    UserServiceProvider userServiceProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JwtGeneratorValidator jwtGeneratorValidator;


    @PostMapping("/userRegister")
    public void addUser(@RequestBody User user) {
        userServiceProvider.setUsers(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userServiceProvider.getAllUsers();
    }

    @PostMapping("/gettoken")
    public String getJwtToken(@RequestBody AuthRequest authRequest) throws  Exception{

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
        }catch (Exception e){
            System.out.println("error invalid userNamePassword");
            System.out.println(e.getMessage());
        }
        return jwtGeneratorValidator.generateToken(authRequest.getUserName());
    }

    @GetMapping("/hello")
    public String defaultMethod() {
        return "Hello World!";
    }

}
