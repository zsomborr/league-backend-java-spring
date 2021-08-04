package com.codecool.league.serviceTest;

import com.codecool.league.dao.repository.UserRepository;
import com.codecool.league.dto.UserDto;
import com.codecool.league.model.user.Role;
import com.codecool.league.model.user.UserModel;
import com.codecool.league.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private UserDto steveDto;
    private UserModel steveModel;
    private UserDto peterDto;
    private UserModel peterModel;
    private final List<String> ids = Arrays.asList("1", "2");

    @BeforeEach
    public void setup() {
        steveDto = UserDto.builder()
                .username("Steve")
                .password("StevePassword")
                .role(Role.USER)
                .build();

        steveModel = UserModel.builder()
                .username("Steve")
                .password("StevePassword")
                .role(Role.USER)
                .favouriteChampionIds(ids)
                .build();

        peterDto = UserDto.builder()
                .username("Peter")
                .password("peterPassword")
                .role(Role.USER)
                .build();

        peterModel = UserModel.builder()
                .username("Peter")
                .password("peterPassword")
                .role(Role.USER)
                .favouriteChampionIds(ids)
                .build();

        userRepository.save(steveModel);

    }

    @Test
    void registerNewUser() {
        userService.registerUser(peterDto);
        assertThat(userRepository.findAll())
                .hasSize(2)
                .anyMatch(userFromRepository -> userFromRepository.getUsername().equals("Peter"));
    }

    @Test
    void registerAlreadyExistingUser() {
        userService.registerUser(steveDto);
        assertThat(userRepository.findAll())
                .hasSize(1)
                .anyMatch(userFromRepository -> userFromRepository.getUsername().equals("Steve"));
    }

}
