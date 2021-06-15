package com.codecool.league.dao.fetch.riotUserDetailsDao;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;

public class RiotUserDetailsDaoFetch implements RiotUserDetailsDao {

    private final String RIOTUSER_INFO_ENDPOINT = "https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"; // + username
    private final String MATCH_HISTORY_ENDPOINT = "https://eun1.api.riotgames.com/lol/match/v4/matchlists/by-account/"; // + accoundId
    private final String MATCH_RESULT_ENDPOINT = "https://eun1.api.riotgames.com/lol/match/v4/matches/"; // + matchId
    @Override
    public RiotUserDetailModel getUserInfo(String userName) {
        RiotUserDetailModel userDetail = null;
        try {
            String userDetailFromApi = Util.getRiotApiJsonResponse(RIOTUSER_INFO_ENDPOINT + userName);
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
            String matchHistoryFromApi = Util.getRiotApiJsonResponse(MATCH_HISTORY_ENDPOINT + accountId + "?endIndex=10");
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
            String matchDetailFromApi = Util.getRiotApiJsonResponse(MATCH_RESULT_ENDPOINT + matchId);
            matchDetail = new Gson().fromJson(matchDetailFromApi, MatchResultModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchDetail;
    }
}
