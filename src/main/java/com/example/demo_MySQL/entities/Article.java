package com.example.demo_MySQL.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "t_articles" )
public class Article {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idarticle;
    private String description;
    private String brand;
    private Double price;
 

    public Integer getIdarticle() {
        return idarticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }
    
    
    
    
}
