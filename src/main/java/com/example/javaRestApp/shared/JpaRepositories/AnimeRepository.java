package com.example.javaRestApp.shared.JpaRepositories;

import com.example.javaRestApp.shared.UserEntities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {

}
