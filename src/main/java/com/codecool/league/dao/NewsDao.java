package com.codecool.league.dao;

import com.codecool.league.model.NewsModel;
import java.util.List;

public interface NewsDao {
    List<NewsModel> getNews(int pageNumber);
}
