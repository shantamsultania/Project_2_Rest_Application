package com.example.javaRestApp.service;

import com.example.javaRestApp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceProvider extends UserDetailsService {

    List<User> getAllUsers();


    void setUsers(User user);

}
