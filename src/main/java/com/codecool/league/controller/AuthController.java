package com.codecool.league.controller;

import com.codecool.league.dto.UserDto;
import com.codecool.league.model.user.Role;
import com.codecool.league.security.JwtTokenServices;
import com.codecool.league.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RestController
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenServices jwtTokenServices;

    @Autowired
    public AuthController(AuthService userService, AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @PostMapping(value = "/login")
    public ResponseEntity validateLogin(@RequestBody UserDto userDto) {
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

    @PostMapping("/register")
    public Boolean registerUser(@RequestBody UserDto userDto) {
        return authService.registerUser(userDto);
    }
}
