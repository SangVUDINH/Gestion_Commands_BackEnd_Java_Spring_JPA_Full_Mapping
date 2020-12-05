package com.example.demo_MySQL.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "t_commandlines" )
public class CommandLine {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idcommandline;
    
    private Integer quantity;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idcommand",nullable=false)
    private Command command;
    
    @Transient
    private Date cmddate;
    
    @ManyToOne
    @JoinColumn(name="idarticle",nullable=false)
    private Article article;

    public Integer getIdcommandline() {
        return idcommandline;
    }

    public void setIdcommandline( Integer idcommandline ) {
        this.idcommandline = idcommandline;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand( Command command ) {
        this.command = command;
    }

    public Date getCmddate() {
        if(command == null) {
            return null;
        }
        return (Date) command.getCommanddate();
    }

    public void setCmddate( Date cmddate ) {
        this.cmddate = cmddate;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle( Article article ) {
        this.article = article;
    }
    
    
    
    
    
}
