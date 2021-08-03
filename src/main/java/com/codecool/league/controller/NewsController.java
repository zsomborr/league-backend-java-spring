package com.codecool.league.controller;

import com.codecool.league.model.news.NewsModel;
import com.codecool.league.service.NewsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class NewsController {

    private final NewsService newsService;
    private Gson gson;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
        this.gson = new Gson();
    }


    @GetMapping("/{pageNumber}")
    public List<NewsModel> getNews(@PathVariable("pageNumber") int pageNumber) {
        return newsService.getNews(pageNumber);
    }

}
