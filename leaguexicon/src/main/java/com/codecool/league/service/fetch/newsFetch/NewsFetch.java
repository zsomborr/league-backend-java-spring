package com.codecool.league.service.fetch.newsFetch;

import com.codecool.league.model.news.NewsModel;

import java.util.List;

public interface NewsFetch {
    List<NewsModel> getNews(int pageNumber);
}