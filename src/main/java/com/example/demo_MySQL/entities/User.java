package com.example.demo_MySQL.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "t_users" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int              iduser;

    private String           login;

    private String           password;

    private int              connectionnumber;

    @OneToOne
    @JoinColumn( name = "iduserinformations", nullable = false )
    private UserInformation userInformation;
    
    @OneToMany(targetEntity=Command.class,mappedBy="user")
    private List<Command> commands= new ArrayList<>();

    public User() {
        
    }

    public int getIduser() {
        return iduser;
    }

  
    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public int getConnectionNumber() {
        return connectionnumber;
    }

    public void setConnectionNumber( int connectionnumber ) {
        this.connectionnumber = connectionnumber;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation( UserInformation userInformation ) {
        this.userInformation = userInformation;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands( List<Command> commands ) {
        this.commands = commands;
    }
    
    
    
    

}
