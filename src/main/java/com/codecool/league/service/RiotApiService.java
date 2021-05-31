package com.codecool.league.service;

import com.codecool.league.dao.RiotApiDao;
import org.springframework.beans.factory.annotation.Autowired;

public class RiotApiService {

    RiotApiDao riotApiDao;

    @Autowired
    public RiotApiService(RiotApiDao riotApiDao) {
        this.riotApiDao = riotApiDao;
    }

    public String getAllChampion() {
        return riotApiDao.getAllChampion();
    }

    public String getFreeChampions() {
        return riotApiDao.getFreeChampions();
    }

    public String getUserInfo(String userName) {
        return riotApiDao.getUserInfo(userName);
    }
}
