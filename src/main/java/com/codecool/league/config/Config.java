package com.codecool.league.config;

import com.codecool.league.dao.championsDao.ChampionsDao;
import com.codecool.league.dao.championsDao.ChampionsDaoFetch;
import com.codecool.league.dao.freeChampionsDao.FreeChampionsDao;
import com.codecool.league.dao.freeChampionsDao.FreeChampionsDaoFetch;
import com.codecool.league.dao.newsDao.NewsDao;
import com.codecool.league.dao.newsDao.NewsDaoFetch;
import com.codecool.league.dao.riotUserDetailsDao.RiotUserDetailsDao;
import com.codecool.league.dao.riotUserDetailsDao.RiotUserDetailsDaoFetch;
import com.codecool.league.dao.userDao.UserDao;
import com.codecool.league.dao.userDao.UserDaoMem;
import com.codecool.league.service.ChampionsService;
import com.codecool.league.service.NewsService;
import com.codecool.league.service.RiotUserService;
import com.codecool.league.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public NewsDao newsDao() {
        return new NewsDaoFetch();
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoMem();
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
        return new UserService(userDao());
    }

    @Bean
    public ChampionsService championsService() {
        return new ChampionsService(championsDao(), freeChampionsDao());
    }

    @Bean
    public NewsService newsService() {
        return new NewsService(newsDao());
    }

    @Bean
    public RiotUserService riotUserService() {
        return new RiotUserService(riotUserDetailsDao());
    }
}
