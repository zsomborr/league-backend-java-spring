package com.codecool.league.service;

import com.codecool.league.dao.RiotUserDetailsDao;
import com.codecool.league.model.MatchHistoryModel;
import com.codecool.league.model.RiotUserDetailModel;
import com.codecool.league.model.matchResults.MatchResultModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RiotUserService {

    RiotUserDetailsDao riotUserDetailsDao;
    RiotUserDetailModel user;
    List<MatchHistoryModel> matchHistory;
    Gson gson;


    @Autowired
    public RiotUserService(RiotUserDetailsDao riotUserDetailsDao) {
        this.riotUserDetailsDao = riotUserDetailsDao;
        this.gson = new Gson();
        matchHistory = new ArrayList<>();
    }

    public String getUserInfo(String userName) {
        user = riotUserDetailsDao.getUserInfo(userName);
        return gson.toJson(user);
    }

    public String getMatchHistory() {
        List<MatchHistoryModel> matchHistory = riotUserDetailsDao.getMatchHistory(user.getAccountId());
        this.matchHistory = matchHistory;
        return gson.toJson(matchHistory);
    }

    public String getMatchDetails() {
        //TODO: check for user's team
        List<MatchResultModel> matchResultModels = new ArrayList<>();
        for (MatchHistoryModel matchHistoryModel : matchHistory) {
            matchResultModels.add(riotUserDetailsDao.getMatchResult(matchHistoryModel.getGameId()));
        }
        return gson.toJson(matchResultModels);
    }

}
