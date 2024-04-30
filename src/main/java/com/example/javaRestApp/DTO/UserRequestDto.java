package com.example.javaRestApp.DTO;

import com.example.javaRestApp.entiy.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    private String userName;
    private String userPassword;
    private Role userRole;
}
