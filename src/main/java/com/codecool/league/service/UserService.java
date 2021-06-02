package com.codecool.league.service;

import com.codecool.league.Model.User;
import com.codecool.league.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean validateLogin(User user) {
        return userDao.validateUser(user);
    }

    public Boolean registerUser(User user) {
        return userDao.registerUser(user);
    }
}
