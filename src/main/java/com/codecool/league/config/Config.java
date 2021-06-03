package com.codecool.league.config;

import com.codecool.league.dao.RiotApiDao;
import com.codecool.league.dao.RiotApiDaoFetch;
import com.codecool.league.dao.UserDao;
import com.codecool.league.dao.UserDaoMem;
import com.codecool.league.service.RiotApiService;
import com.codecool.league.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RiotApiDao riotApiDaoFetch() {
        return new RiotApiDaoFetch();
    }

    @Bean
    public RiotApiService riotApiService() {
        return new RiotApiService(riotApiDaoFetch());
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoMem();
    }

    @Bean
    public UserService userService() {
        return new UserService(userDao());
    }
}
