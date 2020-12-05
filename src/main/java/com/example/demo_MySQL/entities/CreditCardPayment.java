package com.example.demo_MySQL.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_creditcardpayments")
@PrimaryKeyJoinColumn(name="idpayment")
public class CreditCardPayment extends Payment {
    private String cardnumber="unknown";
    private String expirationdate="mm//yy";
    
    
    public CreditCardPayment() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getCardnumber() {
        return cardnumber;
    }
    public void setCardnumber( String cardnumber ) {
        this.cardnumber = cardnumber;
    }
    public String getExpirationDate() {
        return expirationdate;
    }
    public void setExpirationDate( String expirationDate ) {
        this.expirationdate = expirationDate;
    }
    
    

}
