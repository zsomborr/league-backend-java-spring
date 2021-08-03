package com.codecool.league.dto;

import com.codecool.league.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String password;
    private Role role;
}
