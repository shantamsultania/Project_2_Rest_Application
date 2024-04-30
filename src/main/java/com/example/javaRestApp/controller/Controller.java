package com.example.javaRestApp.controller;

import com.example.javaRestApp.service.AnimeServices.AnimeServiceProvider;
import com.example.javaRestApp.service.UserServices.UserServiceProvider;
import com.example.javaRestApp.shared.ApiRequestDto.AuthRequest;
import com.example.javaRestApp.shared.ApiRequestDto.UserDto;
import com.example.javaRestApp.shared.SecurityConfigFiles.JwtGeneratorValidator;
import com.example.javaRestApp.shared.UserEntities.Anime;
import com.example.javaRestApp.shared.UserEntities.User;
import com.example.javaRestApp.shared.utils.Role;
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
public class Controller {


    @Autowired
    UserServiceProvider userServiceProvider;

    @Autowired
    AnimeServiceProvider animeServiceProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    JwtGeneratorValidator jwtGeneratorValidator;

    // register and Authenticate Users

    @PostMapping("/userRegister")
    public void addUser(@RequestBody UserDto userDto) {

        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(Role.user);

        userServiceProvider.setUsers(user);
    }

    @PostMapping("/developerRegister")
    public void addDeveloper(@RequestBody UserDto userDto) {

        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(Role.developer);

        userServiceProvider.setUsers(user);
    }

    @PostMapping("/adminRegister")
    public void addAdmin(@RequestBody UserDto userDto) {

        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());
        user.setUserRole(Role.admin);

        userServiceProvider.setUsers(user);
    }

    // create Valid token
    @PostMapping("/getToken")
    public String getJwtToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
        } catch (Exception e) {
            System.out.println("error invalid userNamePassword");
            System.out.println(e.getMessage());
        }
        return jwtGeneratorValidator.generateToken(authRequest.getUserName());
    }

    // test you are in or not
    @GetMapping("/hello")
    public String defaultMethod() {
        return "Hello World!";
    }

    @GetMapping("/getAllUsersDetails")
    public List<User> getAllUsers() {
        return userServiceProvider.getAllUsers();
    }

    // Demon Slayer List

    @GetMapping("/getAllAnimeDetails")
    public List<Anime> getAllAnime() {

        return animeServiceProvider.getAllAnime();
    }


}
