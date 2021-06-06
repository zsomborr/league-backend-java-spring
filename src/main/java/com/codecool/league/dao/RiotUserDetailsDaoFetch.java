package com.codecool.league.dao;

import com.codecool.league.model.MatchHistoryModel;
import com.codecool.league.model.RiotUserDetailModel;
import com.codecool.league.model.matchResults.MatchResultModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    public List<MatchHistoryModel> getMatchHistory(String accountId) {
        List<MatchHistoryModel> matchHistory = new ArrayList<>();
        try {
            String matchHistoryFromApi = Util.getRiotApiJsonResponse("https://eun1.api.riotgames.com/lol/match/v4/matchlists/by-account/" + accountId);
            Type matchHistoryModelType = new TypeToken<ArrayList<MatchHistoryModel>>(){}.getType();
            matchHistory = new Gson().fromJson(matchHistoryFromApi, matchHistoryModelType);
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
