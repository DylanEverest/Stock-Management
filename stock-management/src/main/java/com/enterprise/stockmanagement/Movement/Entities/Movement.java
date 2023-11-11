package com.enterprise.stockmanagement.Movement.Entities;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.Articles.Repositories.ArticlesRepository;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampUnvalidExcetion;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampValidation;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.ArticlesNotFoundException;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.StoreNotFoundException;
import com.enterprise.stockmanagement.Store.Entities.Store;
import com.enterprise.stockmanagement.Store.Repositories.StoreRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Component
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


    // database access utils
    @Autowired
    @Transient
    private ArticlesRepository  articlesRepository ;

    @Autowired
    @Transient
    private StoreRepository storeRepository ;

// controll

    public void setDateMovement(String timestamp) throws TimestampUnvalidExcetion
    {
        Timestamp timestamp2= new TimestampValidation().isValid(timestamp) ;
        setDateMovement(timestamp2);
    }

    public void setArticles(String articles) throws ArticlesNotFoundException
    {

        if(!articlesRepository.existsFamily(articles)) throw new ArticlesNotFoundException("Article " + articles + " not found");

        setArticles(articlesRepository.findArticlesLikeName(articles).get());
    }

    public void setStore(String store) throws StoreNotFoundException 
    {

        if(!storeRepository.existsStoreName(store)) throw new StoreNotFoundException("Store " + store + " not found");

        setStore(storeRepository.findByStoreName(store).get());

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

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
