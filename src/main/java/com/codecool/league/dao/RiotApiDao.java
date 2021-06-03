package com.codecool.league.dao;

public interface RiotApiDao {
    String getAllChampion();
    String getFreeChampions();
    String getUserInfo(String userName);
    String getMatchHistory(String accountId);
    String getMatchResult(Long matchId);
    String getNews();
}
