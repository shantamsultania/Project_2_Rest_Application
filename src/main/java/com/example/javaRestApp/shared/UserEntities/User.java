package com.example.javaRestApp.shared.UserEntities;

import com.example.javaRestApp.shared.utils.Role;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_table")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private String userPassword;

    private String userEmail;

    private Role userRole;

}
