package com.codecool.league.model.riotUser;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiotUserDetailModel {

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("profileIconId")
    private int profileIconId;

    @SerializedName("name")
    private String name;

    @SerializedName("puuid")
    private String puuid;

    @SerializedName("summonerLevel")
    private int summonerLevel;
}