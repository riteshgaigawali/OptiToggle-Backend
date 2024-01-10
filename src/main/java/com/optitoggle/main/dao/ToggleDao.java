package com.optitoggle.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optitoggle.main.entities.Toggle;
import com.optitoggle.main.entities.User;

public interface ToggleDao extends JpaRepository<Toggle, Integer> {
    List<Toggle> findByUser(User user);

}
