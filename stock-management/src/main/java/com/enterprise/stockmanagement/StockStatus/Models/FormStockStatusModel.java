package com.enterprise.stockmanagement.StockStatus.Models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.Store.Entities.Store;

@Component
public class FormStockStatusModel 
{
    private Timestamp beginDate;

    private Timestamp endDate;

    private Articles article ;
    
    private Store store;


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

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
}
