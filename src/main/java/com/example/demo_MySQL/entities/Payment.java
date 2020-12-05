package com.example.demo_MySQL.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "t_payments" )
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Payment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer idpayment;
    private Double amount;
    private Date paymentdate;
    
    @JsonIgnore
    @OneToOne
    @JoinTable(name="t_commands_payments_associations",
            joinColumns=@JoinColumn(name="idpayment"),
            inverseJoinColumns=@JoinColumn(name="idcommand"))
    private Command command ;
    
    @Transient
    private Date commanddate;
    
    
    
    public Command getCommand() {
        return command;
    }

    public void setCommand( Command command ) {
        this.command = command;
    }

    public Date getCommanddate() {
        if(command != null) {
            return command.getCommanddate();
        }
        return null;
    }

    public void setCommanddate( Date commanddate ) {
        this.commanddate = commanddate;
    }

    public Integer getIdpayment() {
        return idpayment;
    }
   
    public Double getAmount() {
        return amount;
    }
    public void setAmount( Double amount ) {
        this.amount = amount;
    }
    public Date getPaymentdate() {
        return paymentdate;
    }
    public void setPaymentdate( Date paymentdate ) {
        this.paymentdate = paymentdate;
    }
    
    
}
