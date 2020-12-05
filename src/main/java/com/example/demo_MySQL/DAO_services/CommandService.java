package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_MySQL.entities.Command;
import com.example.demo_MySQL.repositories.CommandRepository;

@Service
@Transactional
public class CommandService {
    
    @Autowired
    private CommandRepository repo;
    
    public List<Command> listAll() {
        return repo.findAll();
    }

}
