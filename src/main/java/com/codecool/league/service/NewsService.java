package com.codecool.league.service;

import com.codecool.league.dao.NewsDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsService {

    NewsDao newsDao;


    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public String getNews(int pageNumber) {
        return new Gson().toJson(newsDao.getNews(pageNumber));
    }
}
