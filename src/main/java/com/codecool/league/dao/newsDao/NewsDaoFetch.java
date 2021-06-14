package com.codecool.league.dao.newsDao;

import com.codecool.league.model.news.NewsModel;
import com.codecool.league.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoFetch implements NewsDao {

    @Override
    public List<NewsModel> getNews(int pageNumber) {
        List<NewsModel> news = new ArrayList<>();
        try {
            String newsFromApi = Util.getRiotApiJsonResponse("https://api.hnpwa.com/v0/newest/"+ pageNumber +".json");
            Type newsModelType = new TypeToken<ArrayList<NewsModel>>(){}.getType();
            news = new Gson().fromJson(newsFromApi, newsModelType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
}
