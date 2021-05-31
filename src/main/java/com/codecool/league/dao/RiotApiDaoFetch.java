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

    @Override
    public String getFreeChampions() {
        String freeChampions = null;
        try {
            freeChampions = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/platform/v3/champion-rotations");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freeChampions;
    }

    @Override
    public String getUserInfo(String userName) {
        String usermatchdetail = "https://eun1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + "userDetail.accountID";
        String matchResult = "https://eun1.api.riotgames.com/lol/match/v4/matches/" + "userDetail.accountID";
        String userDetail = null;
        try {
            userDetail = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"  + userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetail;
    }
}
