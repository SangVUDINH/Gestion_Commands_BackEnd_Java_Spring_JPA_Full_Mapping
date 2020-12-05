package com.example.demo_MySQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_MySQL.entities.Article;


public interface ArticleRepository extends JpaRepository<Article,Integer> {

}
