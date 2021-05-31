package com.codecool.league.config;

import com.codecool.league.dao.RiotApiDao;
import com.codecool.league.dao.RiotApiDaoFetch;
import com.codecool.league.service.RiotApiService;
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
}
