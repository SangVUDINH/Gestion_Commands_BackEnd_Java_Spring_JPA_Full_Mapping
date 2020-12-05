package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.Payment;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
