package com.example.javaRestApp.shared.UserEntities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anime {


    @Id
    @JsonProperty("id")
    private Integer characterUniqueId;

    @JsonProperty("name")
    private String characterName;
    @JsonProperty("race")
    private String characterRace;
    @JsonProperty("skill")
    private String characterSkill;
    @JsonProperty("affiliation")
    private String characterAffiliation;
    @JsonProperty("quote")
    @Column(columnDefinition="TEXT")
    private String characterFavoriteQuote;


}
