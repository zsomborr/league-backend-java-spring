package com.codecool.league.dao.fetch.riotUserDetailsDao;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;

public interface RiotUserDetailsDao {
    RiotUserDetailModel getUserInfo(String userName);
    MatchHistoryModel getMatchHistory(String accountId);
    MatchResultModel getMatchResult(Long matchId);
}