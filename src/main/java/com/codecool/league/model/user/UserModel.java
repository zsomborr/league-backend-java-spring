package com.codecool.league.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserModel {

    @GeneratedValue
    @Id
    private Long id;

    private String email;

    private byte[] password;
    private byte[] salt;

}
