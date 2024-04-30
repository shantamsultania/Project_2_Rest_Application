package com.example.javaRestApp;

import com.example.javaRestApp.entiy.Role;
import com.example.javaRestApp.entiy.User;
import com.example.javaRestApp.respository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JavaRestAppApplication {


    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(JavaRestAppApplication.class, args);
    }

    @PostConstruct
    public void initUsers() {
        List<User> usersList = new ArrayList<>();
        for (User user : List.of(new User(101, "testusername", "testusername", "test@gmail.com", Role.admin))) {
            usersList.add(user);
        }

        userRepository.saveAll(usersList);

    }

}
