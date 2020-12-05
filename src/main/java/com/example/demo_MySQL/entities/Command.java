package com.example.demo_MySQL.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_commands")
public class Command {
    
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    @Column(name="idcommand")
    private Integer id;
    private Date commanddate;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="iduser",nullable=false)
    private User user;

    @Transient
    private String userlogin;
    
    @OneToMany(targetEntity=CommandLine.class,mappedBy="command")
    private List<CommandLine> commandlines = new ArrayList<>();
    
    
    public String getUserlogin() {
        if (user == null) {
            return null;
        }
        return user.getLogin();
    }


    public void setUserlogin( String userlogin ) {
        this.userlogin = userlogin;
    }


    public Command() {
        
    }


    
    public List<CommandLine> getCommandlines() {
        return commandlines;
    }


    public void setCommandlines( List<CommandLine> commandlines ) {
        this.commandlines = commandlines;
    }


    public Integer getId() {
        return id;
    }


    public Date getCommanddate() {
        return commanddate;
    }


    public void setCommanddate( Date commanddate ) {
        this.commanddate = commanddate;
    }


    public User getUser() {
        return user;
    }


    public void setUser( User user ) {
        this.user = user;
    }

    






    
    
    
}
