package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_MySQL.entities.Role;
import com.example.demo_MySQL.repositories.RoleRepository;


@Service
@Transactional
public class RoleService {
    
    @Autowired
    private RoleRepository repo;
    
    public List<Role> listAll() {
        return repo.findAll();
    }

}
