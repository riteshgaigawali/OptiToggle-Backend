package com.optitoggle.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optitoggle.main.entities.User;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByEmailid(String emailid);
}
