package com.codecool.league.security;

import com.codecool.league.dao.repository.UserRepository;
import com.codecool.league.model.user.UserModel;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    /**
     * Loads the user from the DB and converts it to Spring Security's internal User object.
     * Spring will call this code to retrieve a user upon login from the DB.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = users.findDistinctByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>(Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()))));
    }
}

