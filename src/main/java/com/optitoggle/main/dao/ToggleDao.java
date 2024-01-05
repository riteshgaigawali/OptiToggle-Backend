package com.optitoggle.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optitoggle.main.entities.Toggle;

public interface ToggleDao extends JpaRepository<Toggle, Integer> {

}
