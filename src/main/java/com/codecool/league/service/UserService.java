package com.codecool.league.service;

import com.codecool.league.dao.repository.UserRepository;
import com.codecool.league.dto.UserDto;
import com.codecool.league.model.user.Role;
import com.codecool.league.security.JwtTokenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codecool.league.model.user.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        this.jwtTokenServices = jwtTokenServices;
    }

    public ResponseEntity validateLogin(UserDto userDto) {
        try {
            String username = userDto.getUsername();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, userDto.getPassword()));
            Role role = Role.valueOf(authentication.getAuthorities().stream().findFirst().orElseThrow().getAuthority());

            String jwt = jwtTokenServices.createToken(username, role);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("role", role);
            model.put("token", jwt);

            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    public Boolean registerUser(UserDto userDto) {
        String username = userDto.getUsername();
        Optional<UserModel> userModelOptional = userRepository.findDistinctByUsername(username);

        if (userModelOptional.isEmpty()) {

            UserModel userModel = UserModel.builder()
                    .username(username)
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .build();

            userRepository.save(userModel);

        }
        return userModelOptional.isEmpty();
    }

}
