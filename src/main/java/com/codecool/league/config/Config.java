package com.codecool.league.config;

import com.codecool.league.dao.fetch.championsDao.ChampionsDao;
import com.codecool.league.dao.fetch.championsDao.ChampionsDaoFetch;
import com.codecool.league.dao.fetch.freeChampionsDao.FreeChampionsDao;
import com.codecool.league.dao.fetch.freeChampionsDao.FreeChampionsDaoFetch;
import com.codecool.league.dao.fetch.newsDao.NewsDao;
import com.codecool.league.dao.fetch.newsDao.NewsDaoFetch;
import com.codecool.league.dao.fetch.riotUserDetailsDao.RiotUserDetailsDao;
import com.codecool.league.dao.fetch.riotUserDetailsDao.RiotUserDetailsDaoFetch;
import com.codecool.league.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public NewsDao newsDao() {
        return new NewsDaoFetch();
    }

    @Bean
    public RiotUserDetailsDao riotUserDetailsDao() {
        return new RiotUserDetailsDaoFetch();
    }

    @Bean
    public ChampionsDao championsDao() {
        return new ChampionsDaoFetch();
    }

    @Bean
    public FreeChampionsDao freeChampionsDao() {
        return new FreeChampionsDaoFetch();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public ChampionsService championsService() {
        return new ChampionsService();
    }

    @Bean
    public NewsService newsService() {
        return new NewsService(newsDao());
    }

    @Bean
    public RiotUserService riotUserService() {
        return new RiotUserService(riotUserDetailsDao());
    }

    @Bean
    public ChampionsDatabaseSetupService championsDatabaseSetupService() {
        return new ChampionsDatabaseSetupService(championsDao(), freeChampionsDao());
    }

    @Bean
    public FavouriteService favouriteService() {
        return new FavouriteService();
    }
}
