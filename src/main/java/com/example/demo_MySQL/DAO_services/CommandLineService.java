package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_MySQL.entities.Command;
import com.example.demo_MySQL.entities.CommandLine;
import com.example.demo_MySQL.repositories.CommandLineRepository;
import com.example.demo_MySQL.repositories.CommandRepository;

@Service
@Transactional
public class CommandLineService {
    
    @Autowired
    private CommandLineRepository repo;
    
    public List<CommandLine> listAll() {
        return repo.findAll();
    }

}
