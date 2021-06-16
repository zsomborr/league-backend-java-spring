package com.codecool.league.dao.newsDao;

import com.codecool.league.model.news.NewsModel;
import java.util.List;

public interface NewsDao {
    List<NewsModel> getNews(int pageNumber);
}