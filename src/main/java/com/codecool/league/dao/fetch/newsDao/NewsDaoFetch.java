package com.codecool.league.dao.fetch.newsDao;

import com.codecool.league.model.news.NewsModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoFetch implements NewsDao {

    private final static String NEWS_API = "https://api.hnpwa.com/v0/newest/";

    @Override
    public List<NewsModel> getNews(int pageNumber) {
        List<NewsModel> news = new ArrayList<>();
        try {
            String newsFromApi = Util.getRiotApiJsonResponse(NEWS_API + pageNumber +".json");
            Type newsModelType = new TypeToken<ArrayList<NewsModel>>(){}.getType();
            news = new Gson().fromJson(newsFromApi, newsModelType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
}