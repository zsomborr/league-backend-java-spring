package com.codecool.league.model.riotUser;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiotUserDetailModel {

    @GeneratedValue
    @Id
    private Long id;

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