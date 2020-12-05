package com.example.demo_MySQL.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_paypalpayments")
@PrimaryKeyJoinColumn(name="idpayment")
public class PaypalPayment extends Payment {
    private String accountnumber ="unknown";

    public PaypalPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getAccountNumber() {
        return accountnumber;
    }

    public void setAccountNumber( String accountNumber ) {
        this.accountnumber = accountNumber;
    }
    
    
}
