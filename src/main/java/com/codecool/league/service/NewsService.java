package com.codecool.league.service;

import com.codecool.league.dao.fetch.newsDao.NewsDao;
import com.codecool.league.model.news.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsService {

    private final NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public List<NewsModel> getNews(int pageNumber) {
        return newsDao.getNews(pageNumber);
    }
}
