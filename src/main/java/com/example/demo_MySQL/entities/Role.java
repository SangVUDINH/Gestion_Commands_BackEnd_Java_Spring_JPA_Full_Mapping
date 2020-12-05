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
import javax.persistence.Table;

@Entity
@Table( name = "t_roles" )
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idrole;
    private String rolename;
    
    @ManyToMany
    @JoinTable(name="t_users_roles_associations",
            joinColumns=@JoinColumn(name="idrole"),
            inverseJoinColumns=@JoinColumn(name="iduser"))
    private List<User> users = new ArrayList<>();
    
    
    

    public Integer getIdrole() {
        return idrole;
    }

    public void setIdrole( Integer idrole ) {
        this.idrole = idrole;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename( String rolename ) {
        this.rolename = rolename;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers( List<User> users ) {
        this.users = users;
    }
    
    
            
}
