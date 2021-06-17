package com.codecool.league.dao.repository;

import com.codecool.league.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findDistinctByEmail(String email);
    UserModel findDistinctByEmailAndPassword(String email, byte[] password);

}