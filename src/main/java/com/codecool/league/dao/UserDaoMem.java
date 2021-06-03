package com.codecool.league.dao;

import com.codecool.league.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserDaoMem implements UserDao{

    @Override
    public Boolean validateUser(User user) {
        try {
            String userList = new String(Files.readAllBytes(Paths.get("src/main/resources/static/userData.json")));
            Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
            ArrayList<User> userModels = new Gson().fromJson(userList, userListType);

            for (User userModel: userModels) {
                if (userModel.getPassword().equals(user.getPassword()) &&
                        userModel.getEmail().equals(user.getEmail())) {
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Failed to get users from file!");
        }
        return false;
    }

    @Override
    public Boolean registerUser(User user) {
        try {
            String userList = new String(Files.readAllBytes(Paths.get("src/main/resources/static/userData.json")));
            ArrayList<User> userModels;
            if (!userList.equals("")) {
                Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
                userModels = new Gson().fromJson(userList, userListType);
            } else {
                userModels = new ArrayList<>();
            }
            userModels.add(user);
            String updatedUserList = new Gson().toJson(userModels);

            FileWriter writer = new FileWriter("src/main/resources/static/userData.json");
            writer.write(updatedUserList);
            writer.flush();
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

