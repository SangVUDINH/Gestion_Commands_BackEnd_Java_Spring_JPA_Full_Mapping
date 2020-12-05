package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.Command;

public interface CommandRepository extends JpaRepository<Command,Integer> {

}
