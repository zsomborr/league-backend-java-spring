package com.codecool.league.service;

import com.codecool.league.dao.riotUserDetailsDao.RiotUserDetailsDao;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RiotUserService {

    RiotUserDetailsDao riotUserDetailsDao;
    RiotUserDetailModel user;
    MatchHistoryModel matchHistory;


    @Autowired
    public RiotUserService(RiotUserDetailsDao riotUserDetailsDao) {
        this.riotUserDetailsDao = riotUserDetailsDao;
    }

    public RiotUserDetailModel getUserInfo(String userName) {
        user = riotUserDetailsDao.getUserInfo(userName);
        return user;
    }

    public List<MatchModel> getMatchHistory() {
        MatchHistoryModel matchHistory = riotUserDetailsDao.getMatchHistory(user.getAccountId());
        this.matchHistory = matchHistory;
        return matchHistory.getMatches();
    }

    public List<MatchResultModel> getMatchDetails() {
        //TODO: check for user's team
        List<MatchResultModel> matchResultModels = new ArrayList<>();
        for (MatchModel matchModel : matchHistory.getMatches()) {
            matchResultModels.add(riotUserDetailsDao.getMatchResult(matchModel.getGameId()));
        }
        return matchResultModels;
    }

}
