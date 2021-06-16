package com.codecool.league.service;

import com.codecool.league.dao.repository.UserRepository;
import com.codecool.league.dto.UserDto;

import com.codecool.league.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codecool.league.util.Util.generateSalt;
import static com.codecool.league.util.Util.hashAndSaltPassword;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean validateLogin(UserDto userDto) {
        String email = userDto.getEmail();
        UserModel user = userRepository.findDistinctByEmail(email);

        if (user != null) {
            byte[] salt = user.getSalt();
            byte[] hashedPassword = hashAndSaltPassword(userDto.getPassword(), salt);
            return userRepository.findDistinctByEmailAndPassword(email, hashedPassword) != null;
        }

        return false;
    }

    public Boolean registerUser(UserDto userDto) {
        String email = userDto.getEmail();
        UserModel user = userRepository.findDistinctByEmail(email);

        if (user == null) {
            byte[] salt = generateSalt();
            byte[] hashedPassword = hashAndSaltPassword(userDto.getPassword(), salt);

            UserModel userModel = new UserModel();
            userModel.setEmail(email);
            userModel.setPassword(hashedPassword);
            userModel.setSalt(salt);

            userRepository.save(userModel);
        }

        return user == null;
    }

}
