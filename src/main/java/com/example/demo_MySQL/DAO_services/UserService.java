package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_MySQL.entities.User;
import com.example.demo_MySQL.entities.UserInformation;
import com.example.demo_MySQL.repositories.UserInformationRepository;
import com.example.demo_MySQL.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository repo;
    

    public List<User> listAll() {
        return repo.findAll();
    }
}
