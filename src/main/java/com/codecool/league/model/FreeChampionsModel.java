package com.codecool.league.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FreeChampionsModel{

    @SerializedName("freeChampionIds")
    private List<Integer> freeChampionIds;

    public void setFreeChampionIds(List<Integer> freeChampionIds){
        this.freeChampionIds = freeChampionIds;
    }

    public List<Integer> getFreeChampionIds(){
        return freeChampionIds;
    }
}