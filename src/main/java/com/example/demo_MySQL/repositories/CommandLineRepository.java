package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.CommandLine;


public interface CommandLineRepository extends JpaRepository<CommandLine,Integer> {

}
