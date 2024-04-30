package com.example.javaRestApp.service;

import com.example.javaRestApp.DTO.UserRequestDto;
import com.example.javaRestApp.entiy.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceProvider extends UserDetailsService {

    List<User> getAllUsers();


    void setUsers(User user);

}
