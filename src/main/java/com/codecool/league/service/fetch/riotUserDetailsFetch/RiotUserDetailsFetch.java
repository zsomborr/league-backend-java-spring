package com.codecool.league.service.fetch.riotUserDetailsFetch;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;

public interface RiotUserDetailsFetch {
    RiotUserDetailModel getUserInfo(String userName);
    MatchHistoryModel getMatchHistory(String accountId);
    MatchResultModel getMatchResult(Long matchId);
}