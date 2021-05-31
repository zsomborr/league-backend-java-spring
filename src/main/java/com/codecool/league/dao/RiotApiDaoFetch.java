package com.codecool.league.dao;

import com.codecool.league.util.Util;

public class RiotApiDaoFetch implements RiotApiDao{

    @Override
    public String getAllChampion() {
        String champions = null;
        try {
            champions = Util.getRiotApiJsonResponse("http://ddragon.leagueoflegends.com/cdn/11.10.1/data/en_US/champion.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return champions;
    }
}
