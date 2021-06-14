package com.codecool.league.model.user;

public class UserModel {
    private String email;
    private String password;

    public UserModel(String email, String password){
        this.email=email;
        this.password=password;
    }

    public String getEmail(){return this.email;}

    public String getPassword(){return this.password;}

}
