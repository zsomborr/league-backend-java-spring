package com.codecool.league.service;

import com.codecool.league.repository.UserRepository;
import com.codecool.league.dto.UserDto;
import com.codecool.league.model.user.Role;
import org.springframework.beans.factory.annotation.Autowired;

import com.codecool.league.model.user.UserModel;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public Boolean registerUser(UserDto userDto) {
        String username = userDto.getUsername();
        Optional<UserModel> userModelOptional = userRepository.findDistinctByUsername(username);

        if (userModelOptional.isEmpty()) {

            UserModel userModel = UserModel.builder()
                    .username(username)
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .role(Role.USER)
                    .build();

            userRepository.save(userModel);

        }
        return userModelOptional.isEmpty();
    }

}
