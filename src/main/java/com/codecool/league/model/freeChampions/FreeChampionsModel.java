package com.codecool.league.model.freeChampions;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeChampionsModel{

    @SerializedName("freeChampionIds")
    private List<Integer> freeChampionIds;
}