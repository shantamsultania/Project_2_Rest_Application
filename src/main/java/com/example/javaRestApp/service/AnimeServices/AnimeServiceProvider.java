package com.example.javaRestApp.service.AnimeServices;

import com.example.javaRestApp.shared.UserEntities.Anime;

import java.util.List;

public interface AnimeServiceProvider {

    List<Anime> getAllAnime();

    void addAnime(Anime anime);

}
