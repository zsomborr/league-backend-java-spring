package com.codecool.league.dao.fetch.riotUserDetailsDao;

import com.codecool.league.model.riotUser.RiotUserDetailModel;
import com.codecool.league.model.riotUser.matchHistory.MatchHistoryModel;
import com.codecool.league.model.riotUser.matchHistory.MatchModel;
import com.codecool.league.model.riotUser.matchResults.MatchResultModel;
import com.codecool.league.model.riotUser.matchResults.Teams;
import com.codecool.league.util.Util;
import com.google.gson.Gson;

import java.io.IOException;

public class RiotUserDetailsDaoFetch implements RiotUserDetailsDao {

    private final String RIOTUSER_INFO_ENDPOINT = "https://eun1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"; // + username
    private final String MATCH_HISTORY_ENDPOINT = "https://eun1.api.riotgames.com/lol/match/v4/matchlists/by-account/"; // + accoundId
    private final String MATCH_RESULT_ENDPOINT = "https://eun1.api.riotgames.com/lol/match/v4/matches/"; // + matchId

    @Override
    public RiotUserDetailModel getUserInfo(String userName) {
        try {
            String userDetailFromApi = Util.getRiotApiJsonResponse(RIOTUSER_INFO_ENDPOINT + userName);
            return new Gson().fromJson(userDetailFromApi, RiotUserDetailModel.class);
        } catch (IOException e) {
            System.out.println("No such user");
        }
        return RiotUserDetailModel.builder()
                .name("Not found")
                .summonerLevel(0)
                .build();
    }

    @Override
    public MatchHistoryModel getMatchHistory(String accountId) {
        try {
            String matchHistoryFromApi = Util.getRiotApiJsonResponse(MATCH_HISTORY_ENDPOINT + accountId + "?endIndex=10");
            return new Gson().fromJson(matchHistoryFromApi, MatchHistoryModel.class);
        } catch (IOException e) {
            System.out.println("No such match history");
        }
        return MatchHistoryModel.builder()
                .match(MatchModel.builder()
                        .gameId(1)
                        .champion(300000)
                        .build())
                .build();
    }

    @Override
    public MatchResultModel getMatchResult(Long matchId) {
        try {
            String matchDetailFromApi = Util.getRiotApiJsonResponse(MATCH_RESULT_ENDPOINT + matchId);
            return new Gson().fromJson(matchDetailFromApi, MatchResultModel.class);
        } catch (IOException e) {
            System.out.println("No such match result");
        }
        return MatchResultModel.builder()
                .gameId(1)
                .gameMode("No game")
                .gameDuration(0)
                .team(Teams.builder()
                        .teamId(2)
                        .win("no result").build())
                .team(Teams.builder()
                        .teamId(1)
                        .win("no result")
                        .build())
                .build();
    }
}
