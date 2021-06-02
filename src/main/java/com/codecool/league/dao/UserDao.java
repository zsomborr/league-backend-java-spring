package com.codecool.league.dao;

import com.codecool.league.Model.User;

public interface UserDao {
    Boolean validateUser(User user);
    Boolean registerUser(User user);
}
