package com.example.javaRestApp.service.AnimeServices;

import com.example.javaRestApp.shared.JpaRepositories.AnimeRepository;
import com.example.javaRestApp.shared.UserEntities.Anime;
import com.example.javaRestApp.shared.utils.Constants;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.javaRestApp.shared.utils.Common.generateAnimeList;
import static com.example.javaRestApp.shared.utils.Common.readDataInput;

@Service
public class AnimeServiceProviderImpl implements AnimeServiceProvider {

    @Autowired
    AnimeRepository animeRepository;


    @PostConstruct
    void animeInit() {

        List<Anime> initAnimeList = new ArrayList<>();

        try {
            String inputString = readDataInput(Constants.jsonPath);

            initAnimeList = generateAnimeList(inputString);

            System.out.println(initAnimeList.get(0));
            animeRepository.saveAll(initAnimeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Anime> getAllAnime() {


        List<Anime> animeList = new ArrayList<>();

        animeList = animeRepository.findAll();
        return animeList;
    }

    @Override
    public void addAnime(Anime anime) {
        animeRepository.save(anime);
    }

}
