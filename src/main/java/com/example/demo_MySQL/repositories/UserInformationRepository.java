package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.UserInformation;

public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {

}
