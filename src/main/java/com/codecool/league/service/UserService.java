package com.codecool.league.service;

import com.codecool.league.model.user.UserModel;
import com.codecool.league.dao.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean validateLogin(UserModel userModel) {
        return userDao.getUser(userModel);
    }

    public Boolean registerUser(UserModel userModel) {
        return userDao.addUser(userModel);
    }
}
