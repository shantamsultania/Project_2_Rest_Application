package com.example.javaRestApp.service.UserServices;

import com.example.javaRestApp.shared.UserEntities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserServiceProvider extends UserDetailsService {

    List<User> getAllUsers();


    void setUsers(User user);

}
