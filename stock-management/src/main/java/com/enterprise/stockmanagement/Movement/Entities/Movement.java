package com.enterprise.stockmanagement.Movement.Entities;

import java.sql.Timestamp;


import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampUnvalidExcetion;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampValidation;
import com.enterprise.stockmanagement.Quantity.QuantityException;
import com.enterprise.stockmanagement.Store.Entities.Store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Movement 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movementId;

    private Timestamp dateMovement;

    private Integer methodType ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private Articles articles ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private Store store ;

    @Column(nullable = false )
    private Double quantity ;


// controll

    public void setDateMovement(String timestamp) throws TimestampUnvalidExcetion
    {
        Timestamp timestamp2= new TimestampValidation().isValid(timestamp) ;
        setDateMovement(timestamp2);
    }


    public void setQuantity(String quantity) throws QuantityException ,NumberFormatException{
        Double value = Double.valueOf(quantity) ;
        if (value <=0) {
         throw new QuantityException("Quantity must be positive");   
        }
        this.quantity = value;
    }

// standard
    public Integer getMovementId() {
        return movementId;
    }

    public void setMovementId(Integer movementId) {
        this.movementId = movementId;
    }

    public Timestamp getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Timestamp dateMovement) {
        this.dateMovement = dateMovement;
    }

    public Integer getMethodType() {
        return methodType;
    }

    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getQuantity() {
        return quantity;
    }


}
