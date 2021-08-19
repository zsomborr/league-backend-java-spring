package com.codecool.league.service;

import com.codecool.league.service.fetch.riotUserDetailsFetch.RiotUserDetailsFetch;
import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiotUserService {

    private final RiotUserDetailsFetch riotUserDetailsFetchService;
    private RiotUserDetailModel user;
    private MatchHistoryModel matchHistory;


    @Autowired
    public RiotUserService(RiotUserDetailsFetch riotUserDetailsDao) {
        this.riotUserDetailsFetchService = riotUserDetailsDao;
    }

    public RiotUserDetailModel getUserInfo(String userName) {
        user = riotUserDetailsFetchService.getUserInfo(userName);
        return user;
    }

    public List<MatchModel> getMatchHistory() {
        MatchHistoryModel matchHistory = riotUserDetailsFetchService.getMatchHistory(user.getAccountId());
        this.matchHistory = matchHistory;
        return matchHistory.getMatches();
    }

    public List<MatchResultModel> getMatchDetails() {
        //TODO: check for user's team
        List<MatchResultModel> matchResultModels = new ArrayList<>();
        for (MatchModel matchModel : matchHistory.getMatches()) {
            matchResultModels.add(riotUserDetailsFetchService.getMatchResult(matchModel.getGameId()));
        }
        return matchResultModels;
    }

}
