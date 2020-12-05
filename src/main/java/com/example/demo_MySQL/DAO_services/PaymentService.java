package com.example.demo_MySQL.DAO_services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_MySQL.entities.Payment;
import com.example.demo_MySQL.repositories.PaymentRepository;


@Service
@Transactional
public class PaymentService {
    
    @Autowired
    private PaymentRepository repo;
    
    public List<Payment> listAll() {
        return repo.findAll();
    }

}
