package com.codecool.league.dao.userDao;

import com.codecool.league.model.user.UserModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserDaoMem implements UserDao {

    @Override
    public Boolean getUser(UserModel user) {
        try {
            String userList = new String(Files.readAllBytes(Paths.get("src/main/resources/static/userData.json")));
            Type userListType = new TypeToken<ArrayList<UserModel>>(){}.getType();
            ArrayList<UserModel> userModelModels = new Gson().fromJson(userList, userListType);

            for (UserModel userModel: userModelModels) {
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
    public Boolean addUser(UserModel userModel) {
        try {
            String userList = new String(Files.readAllBytes(Paths.get("src/main/resources/static/userData.json")));
            ArrayList<UserModel> userModelModels;
            if (!userList.equals("")) {
                Type userListType = new TypeToken<ArrayList<UserModel>>(){}.getType();
                userModelModels = new Gson().fromJson(userList, userListType);
            } else {
                userModelModels = new ArrayList<>();
            }
            userModelModels.add(userModel);
            String updatedUserList = new Gson().toJson(userModelModels);

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

