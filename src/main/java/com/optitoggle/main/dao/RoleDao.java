package com.optitoggle.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optitoggle.main.entities.Roles;

public interface RoleDao extends JpaRepository<Roles, Integer> {

}
