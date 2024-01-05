package com.optitoggle.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optitoggle.main.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
