package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
