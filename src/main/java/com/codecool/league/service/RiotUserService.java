package com.codecool.league.service;

import com.codecool.league.dao.riotUserDetailsDao.RiotUserDetailsDao;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RiotUserService {

    RiotUserDetailsDao riotUserDetailsDao;
    RiotUserDetailModel user;
    MatchHistoryModel matchHistory;
    Gson gson;


    @Autowired
    public RiotUserService(RiotUserDetailsDao riotUserDetailsDao) {
        this.riotUserDetailsDao = riotUserDetailsDao;
        this.gson = new Gson();
    }

    public String getUserInfo(String userName) {
        user = riotUserDetailsDao.getUserInfo(userName);
        return gson.toJson(user);
    }

    public String getMatchHistory() {
        MatchHistoryModel matchHistory = riotUserDetailsDao.getMatchHistory(user.getAccountId());
        this.matchHistory = matchHistory;
        return gson.toJson(matchHistory.getMatches());
    }

    public String getMatchDetails() {
        //TODO: check for user's team
        List<MatchResultModel> matchResultModels = new ArrayList<>();
        for (MatchModel matchModel : matchHistory.getMatches()) {
            matchResultModels.add(riotUserDetailsDao.getMatchResult(matchModel.getGameId()));
        }
        return gson.toJson(matchResultModels);
    }

}
