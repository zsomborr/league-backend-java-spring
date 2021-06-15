package com.codecool.league.model.freeChampions;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeChampionsModel {

    @GeneratedValue
    @Id
    private Long id;

    @SerializedName("freeChampionIds")
    private List<Integer> freeChampionIds;
}