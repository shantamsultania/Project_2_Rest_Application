package com.example.javaRestApp.shared.JpaRepositories;

import com.example.javaRestApp.shared.UserEntities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

}
