package com.example.demo_MySQL.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="t_userinformations")
public class UserInformation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idinformations")
    private Integer id;
    
    private String address;
    private String city;
    
    @Column(name="phonenumber")
    private String phoneNumber;
    
    @JsonIgnore
    @OneToOne( mappedBy = "userInformation" )
    private User   user;
    
    @Transient
    private String userLogin;
    
    
    
    public String getUserLogin() {
        
        if (user ==null) {
            return null;
        }
        return user.getLogin();
    }

    public void setUserLogin( String userLogin ) {
        this.userLogin = userLogin;
    }

    public UserInformation() {
        
    }

    public UserInformation( Integer id, String address, String city, String phoneNumber ) {
        super();
        this.id = id;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }
    
    

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    
    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    
    
}
