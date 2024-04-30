package com.example.javaRestApp.shared.ApiRequestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AnimeDto {
    private Integer characterUniqueId;

    private String characterName;
}
