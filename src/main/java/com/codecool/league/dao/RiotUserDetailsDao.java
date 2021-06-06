package com.codecool.league.dao;

import com.codecool.league.model.MatchHistoryModel;
import com.codecool.league.model.RiotUserDetailModel;
import com.codecool.league.model.matchResults.MatchResultModel;

import java.util.List;

public interface RiotUserDetailsDao {
    RiotUserDetailModel getUserInfo(String userName);
    List<MatchHistoryModel> getMatchHistory(String accountId);
    MatchResultModel getMatchResult(Long matchId);
}
