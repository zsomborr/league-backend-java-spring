package com.codecool.league.dao;

public interface RiotApiDao {
    String getAllChampion();
    String getFreeChampions();
    String getUserInfo(String userName);
}
