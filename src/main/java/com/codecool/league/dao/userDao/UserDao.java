package com.codecool.league.dao.userDao;

import com.codecool.league.model.user.UserModel;

public interface UserDao {
    Boolean getUser(UserModel userModel);
    Boolean addUser(UserModel userModel);
}
