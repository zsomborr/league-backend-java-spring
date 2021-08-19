package com.codecool.league.model.champions;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionIdAndKeyModel {

    @SerializedName("id")
    private String id;

    @SerializedName("key")
    private String key;

}