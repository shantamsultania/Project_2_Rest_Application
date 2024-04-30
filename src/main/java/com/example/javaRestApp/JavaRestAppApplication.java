package com.example.javaRestApp;

import com.example.javaRestApp.shared.utils.Role;
import com.example.javaRestApp.shared.UserEntities.User;
import com.example.javaRestApp.shared.JpaRepositories.UserRepository;
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


}
