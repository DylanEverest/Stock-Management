package com.enterprise.stockmanagement.StockStatus.Models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;


@Component
public class StockStatusModel 
{
    private Double finalQuantity;

    private Double initialQuantity ;

    private Double priceValue ;

    private String article ;
    
    private String store;

    private Timestamp beginDate;

    private Timestamp endDate;


    public Double getFinalQuantity() 
    {
        return finalQuantity;
    }

    public void setFinalQuantity(Double finalQuantity) 
    {
        this.finalQuantity = finalQuantity;
    }

    public Double getInitialQuantity() 
    {
        return initialQuantity;
    }

    public void setInitialQuantity(Double initialQuantity) 
    {
        this.initialQuantity = initialQuantity;
    }

    public Double getPriceValue() {
        return priceValue;
    }

    public void setPriceValue(Double priceValue) {
        this.priceValue = priceValue;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    
}
