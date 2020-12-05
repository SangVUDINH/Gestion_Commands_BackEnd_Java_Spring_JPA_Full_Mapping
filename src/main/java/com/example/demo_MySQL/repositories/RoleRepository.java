package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.Role;


public interface RoleRepository extends JpaRepository<Role,Integer> {

}
