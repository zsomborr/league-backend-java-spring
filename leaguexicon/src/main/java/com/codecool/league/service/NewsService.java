package com.codecool.league.service;

import com.codecool.league.service.fetch.newsFetch.NewsFetch;
import com.codecool.league.model.news.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NewsService {

    private final NewsFetch newsFetchService;

    @Autowired
    public NewsService(NewsFetch newsDao) {
        this.newsFetchService = newsDao;
    }

    public List<NewsModel> getNews(int pageNumber) {
        return newsFetchService.getNews(pageNumber);
    }
}
