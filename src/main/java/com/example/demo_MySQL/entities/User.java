package com.example.demo_MySQL.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="t_users_roles_associations",
            joinColumns=@JoinColumn(name="iduser"),
            inverseJoinColumns=@JoinColumn(name="idrole"))
    private List<Role> roles = new ArrayList<>();
    
    @Transient
    private List<String> rolenames = new ArrayList<>();
       
 

    public List<String> getRolenames() {
        if (roles != null) {
            List<String> rolenames = new ArrayList<>();
            
            for (Role role:roles) {
                rolenames.add( role.getRolename() );
            }
            return rolenames;
            
        }
       return null;
    }


    public void setRolenames( List<String> rolenames ) {
        this.rolenames = rolenames;
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


    public List<Role> getRoles() {
        return roles;
    }


    public void setRoles( List<Role> roles ) {
        this.roles = roles;
    }
    
    
    
    
    
    

}
