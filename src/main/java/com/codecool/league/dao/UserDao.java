package com.codecool.league.dao;

import com.codecool.league.model.UserModel;

public interface UserDao {
    Boolean getUser(UserModel userModel);
    Boolean addUser(UserModel userModel);
}
