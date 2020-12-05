package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_MySQL.entities.UserInformation;
import com.example.demo_MySQL.repositories.UserInformationRepository;

@Service
@Transactional
public class UserInformationService {
    
    @Autowired
    private UserInformationRepository repo;
    

    public List<UserInformation> listAll() {
        return repo.findAll();
    }
}
