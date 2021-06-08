package com.codecool.league.dao;

import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RiotUserDetailsDaoFetch implements RiotUserDetailsDao{
    @Override
    public RiotUserDetailModel getUserInfo(String userName) {
        RiotUserDetailModel userDetail = null;
        try {
            String userDetailFromApi = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + userName);
            userDetail = new Gson().fromJson(userDetailFromApi, RiotUserDetailModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetail;
    }

    @Override
    public MatchHistoryModel getMatchHistory(String accountId) {
        MatchHistoryModel matchHistory = null;
        try {
            String matchHistoryFromApi = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId + "?endIndex=10");
//            Type matchHistoryModelType = new TypeToken<ArrayList<MatchModel>>(){}.getType();
            matchHistory = new Gson().fromJson(matchHistoryFromApi, MatchHistoryModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchHistory;
    }

    @Override
    public MatchResultModel getMatchResult(Long matchId) {
        MatchResultModel matchDetail = null;
        try {
            String matchDetailFromApi = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/match/v4/matches/" + matchId);
            matchDetail = new Gson().fromJson(matchDetailFromApi, MatchResultModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchDetail;
    }
}
