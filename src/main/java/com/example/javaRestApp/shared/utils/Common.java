package com.example.javaRestApp.shared.utils;

import com.example.javaRestApp.shared.UserEntities.Anime;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Common {

    public static List<Anime> generateAnimeList(String inputString) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, Anime.class);

        List<Anime> animeList = new ArrayList<>();
        try {

            animeList = mapper.readValue(inputString, collectionType);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return animeList;
    }

    public static String readDataInput(String path) throws Exception {
        File initialfile = new File(path);
        InputStream inputStream = new FileInputStream(initialfile);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();

    }
}
